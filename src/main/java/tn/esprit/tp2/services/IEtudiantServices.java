package tn.esprit.tp2.services;

import tn.esprit.tp2.entities.Etudiant;
import java.util.List;

public interface IEtudiantServices {

    // Récupérer tous les étudiants
    List<Etudiant> retrieveAllEtudiants();

    // Ajouter un étudiant
    Etudiant addEtudiant(Etudiant etudiant);

    // Mettre à jour un étudiant
    Etudiant updateEtudiant(Etudiant et);

    // Récupérer un étudiant par son ID
    Etudiant retrieveEtudiant(Long idEtudiant);

    // Supprimer un étudiant
    void removeEtudiant(Long idEtudiant);
}

