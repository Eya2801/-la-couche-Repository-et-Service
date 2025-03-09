package tn.esprit.tp2.services;

import tn.esprit.tp2.entities.Reservation;

import java.util.List;

public interface IReservationServices {

    // Récupérer toutes les réservations
    List<Reservation> retrieveAllReservation();

    // Mettre à jour une réservation
    Reservation updateReservation(Reservation res);

    // Récupérer une réservation par son ID
    Reservation retrieveReservation(String idReservation);

    // Ajouter une réservation
    Reservation ajouterReservation(long idBloc, long cinEtudiant);

    // Annuler une réservation
    Reservation annulerReservation(long cinEtudiant);

    // Récupérer les réservations par année universitaire et nom d'université
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(int anneeUniversite, String nomUniversite);
}
