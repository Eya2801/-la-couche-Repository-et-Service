package tn.esprit.tp2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp2.entities.Reservation;
import tn.esprit.tp2.services.IReservationServices;

import java.util.List;

@RequestMapping("/reservation")
@RestController
@AllArgsConstructor
public class ReservationController {

    private final IReservationServices reservationServices;

    // Récupérer toutes les réservations
    @GetMapping("/retrieveAllReservations")
    public List<Reservation> getReservations() {
        return reservationServices.retrieveAllReservation();
    }

    // Récupérer une réservation par son ID
    @GetMapping("/retrieveReservation/{reservationid}")
    public Reservation retrieveReservation(@PathVariable String reservationid) {
        return reservationServices.retrieveReservation(reservationid);
    }

    // Mettre à jour une réservation
    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation res) {
        return reservationServices.updateReservation(res);
    }

    // Ajouter une réservation
    @PostMapping("/add/{idBloc}/{cinEtudiant}")
    public Reservation addReservation(@PathVariable long idBloc, @PathVariable long cinEtudiant) {
        return reservationServices.ajouterReservation(idBloc, cinEtudiant);
    }

    // Récupérer les réservations par année universitaire et nom d'université
    @GetMapping("/getReservationByYearAndUniversity")
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(
            @RequestParam("anneeUniversite") int anneeUniversite,
            @RequestParam("nomUniversite") String nomUniversite) {
        return reservationServices.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite);
    }
}
