package tn.esprit.tp2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp2.entities.Bloc;
import tn.esprit.tp2.entities.Chambre;
import tn.esprit.tp2.entities.Etudiant;
import tn.esprit.tp2.entities.Reservation;
import tn.esprit.tp2.repositories.IBlocRepository;
import tn.esprit.tp2.repositories.IChambreRepository;
import tn.esprit.tp2.repositories.IEtudiantRepository;
import tn.esprit.tp2.repositories.IReservationRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class IReservationServicesImpl implements IReservationServices {

    private final IReservationRepository reservationRepository;
    private final IBlocRepository blocRepository;
    private final IEtudiantRepository etudiantRepository;
    private final IChambreRepository chambreRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc introuvable"));

        // Trouver une chambre disponible dans le bloc
        Chambre chambre = bloc.getChambre().stream()
                .filter(c -> c.getReservations().size() < c.getCapaciteMax())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucune chambre disponible dans ce bloc"));

        Etudiant etudiant = etudiantRepository.findByCinEtudiant(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));

        // Créer la réservation
        Reservation reservation = new Reservation();
        reservation.setDateReservation(new Date());
        reservation.setEstValide(true);

        // Associer la réservation à la chambre et à l'étudiant
        chambre.getReservations().add(reservation);
        etudiant.getReservations().add(reservation);

        // Sauvegarder et retourner la réservation
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCinEtudiant(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));

        // Trouver la première réservation de l'étudiant
        Reservation reservation = etudiant.getReservations().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucune réservation trouvée"));

        // Annuler la réservation et mettre à jour la chambre
        reservation.setEstValide(false);
        etudiant.getReservations().remove(reservation);

        // Désaffecter la chambre et mettre à jour la capacité
        Chambre chambre = reservation.getChambre();
        if (chambre != null) {
            chambre.getReservations().remove(reservation);
            chambre.setCapaciteMax(chambre.getCapaciteMax() + 1);
            chambreRepository.save(chambre);
        }

        // Sauvegarder la réservation et l'étudiant
        reservationRepository.save(reservation);
        etudiantRepository.save(etudiant);

        return reservation;
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(int anneeUniversite, String nomUniversite) {
        return reservationRepository.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite);
    }
}
