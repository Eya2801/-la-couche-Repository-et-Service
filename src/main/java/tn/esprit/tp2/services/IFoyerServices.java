package tn.esprit.tp2.services;


import tn.esprit.tp2.entities.Etudiant;
import tn.esprit.tp2.entities.Foyer;


import java.util.List;

public interface IFoyerServices {

     Foyer findByid(long id);
    List<Foyer> findAll();
     Foyer save (Foyer foyer);
   void delete(Foyer foyer);
     List<Foyer> retrieveAllFoyers();

     Foyer addFoyer (Foyer f);

     Foyer updateFoyer (Foyer f);
    Foyer retrieveFoyer (long  idFoyer);

     void removeFoyer (long idFoyer);

     Foyer getNomCapacite(String nomFoyer, Long capaciteFoyer);


}
