package tn.esprit.tp2.services;

import tn.esprit.tp2.entities.Chambre;

import java.util.List;

public interface IChambreServices {

    List<Chambre> retrieveAllChambres();

    Chambre  addChambre(Chambre c);

    Chambre updateChambre (Chambre  c);

    Chambre retrieveChambre (long idChambre);

}
