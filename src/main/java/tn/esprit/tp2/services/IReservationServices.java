package tn.esprit.tp2.services;

import tn.esprit.tp2.entities.Reservation;

import java.util.List;

public interface IReservationServices {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation (Reservation  res);

    Reservation retrieveReservation (String idReservation);

}
