package tn.esprit.tp2.services;

import tn.esprit.tp2.entities.Chambre;
import tn.esprit.tp2.entities.Universite;

import java.util.List;

public interface IUniversiteServices {

    List<Universite> retrieveAllUniversities();

    Universite addUniversite(Universite u);

    Universite updateUniversite(Universite u);

    Universite retrieveUniversite(long idUniversite);

    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite(long idUniversite);

    List<Chambre> getChambresParNomUniversite(String nomUniversite);
}
