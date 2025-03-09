package tn.esprit.tp2.services;

import tn.esprit.tp2.entities.Foyer;

import java.util.List;

public interface IFoyerServices {

    // Récupérer un foyer par son ID
    Foyer findByid(long id);

    // Récupérer tous les foyers
    List<Foyer> findAll();

    // Sauvegarder un foyer
    Foyer save(Foyer foyer);

    // Supprimer un foyer
    void delete(Foyer foyer);

    // Récupérer tous les foyers
    List<Foyer> retrieveAllFoyers();

    // Ajouter un foyer
    Foyer addFoyer(Foyer f);

    // Mettre à jour un foyer
    Foyer updateFoyer(Foyer f);

    // Récupérer un foyer par son ID
    Foyer retrieveFoyer(long idFoyer);

    // Supprimer un foyer par son ID
    void removeFoyer(long idFoyer);

    // Récupérer un foyer par son nom et sa capacité
    Foyer getNomCapacite(String nomFoyer, Long capaciteFoyer);

    // Ajouter un foyer et l'affecter à une université
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
