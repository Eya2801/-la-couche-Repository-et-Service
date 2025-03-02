package tn.esprit.tp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp2.entities.Reservation;

@Repository

public interface IReservationRepository extends JpaRepository<Reservation, String> {
}
