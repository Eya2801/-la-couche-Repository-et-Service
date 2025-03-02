package tn.esprit.tp2.services;

import tn.esprit.tp2.entities.Etudiant;

import java.util.List;

public interface IEtudiantServices {

    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant etudiant);

    Etudiant updateEtudiant(Etudiant et);

    Etudiant retrieveEtudiant(long idEtudiant);

    void removeEtudiant(long idEtudiant);
}
