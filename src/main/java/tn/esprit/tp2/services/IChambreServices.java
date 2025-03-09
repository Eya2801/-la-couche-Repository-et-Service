package tn.esprit.tp2.services;

import tn.esprit.tp2.entities.Bloc;
import tn.esprit.tp2.entities.Chambre;
import tn.esprit.tp2.entities.TypeChambre;

import java.util.List;

public interface IChambreServices {

    // Ajout d'une chambre
    Chambre addChambre(Chambre chambre);

    // Ajout de plusieurs chambres
    List<Chambre> addChambres(List<Chambre> chambres);

    // Mise à jour d'une chambre
    Chambre updateChambre(Chambre chambre);

    // Mise à jour de plusieurs chambres
    List<Chambre> updateChambres(List<Chambre> chambres);

    // Suppression d'une chambre
    void deleteChambre(Chambre chambre);

    // Suppression d'une chambre par son ID
    void deleteChambreById(Long id);

    // Suppression de toutes les chambres
    void deleteAll();

    // Suppression de plusieurs chambres
    void deleteAll(List<Chambre> chambres);

    // Suppression de plusieurs chambres par leurs IDs
    void deleteAllById(List<Long> ids);

    // Récupérer toutes les chambres
    List<Chambre> findAll();

    // Récupérer une chambre par son ID
    Chambre findById(Long id);

    // Compter le nombre total de chambres
    long count();

    // Vérifier si une chambre existe par son ID
    boolean existsById(Long id);

    // Rechercher des chambres par numéro
    List<Chambre> findByNumeroChambre(Long num);

    // Rechercher des chambres par type
    List<Chambre> findByTypeC(TypeChambre type);

    // Rechercher des chambres par ID de bloc
    List<Chambre> findByBlocIdBloc(Long blocId);

    // Rechercher des chambres par type et bloc
    List<Chambre> findByTypeCAndBloc(TypeChambre type, Bloc bloc);

    // Rechercher des chambres par numéro et type
    List<Chambre> findByNumeroChambreAndTypeC(Long num, TypeChambre type);

    // Rechercher des chambres par numéro et bloc
    List<Chambre> findByNumeroChambreAndBloc(Long num, Bloc bloc);

    // Compter le nombre de chambres dans un foyer avec un certain type
    long countChambreByBlocFoyerNomFoyerAndTypeC(String nomFoy, TypeChambre type);

    // Rechercher des chambres par nom de bloc
    List<Chambre> getChambreByNomBloc(String nomBloc);
}
