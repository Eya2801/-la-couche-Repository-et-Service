package tn.esprit.tp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tp2.entities.Reservation;

import java.util.List;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, String> {

    // Requête personnalisée pour récupérer les réservations par année universitaire et nom d'université
    @Query("SELECT r FROM Reservation r WHERE FUNCTION('YEAR', r.dateReservation) = :anneeUniversite AND r.universite.nomUniversite = :nomUniversite")
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(
            @Param("anneeUniversite") int anneeUniversite,
            @Param("nomUniversite") String nomUniversite
    );
}
