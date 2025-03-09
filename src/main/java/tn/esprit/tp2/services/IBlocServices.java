package tn.esprit.tp2.services;

import tn.esprit.tp2.entities.Bloc;

import java.util.List;

public interface IBlocServices {

    // Récupérer tous les blocs
    List<Bloc> retrieveBlocs();

    // Mettre à jour un bloc
    Bloc updateBloc(Bloc bloc);

    // Ajouter un bloc
    Bloc addBloc(Bloc bloc);

    // Récupérer un bloc par son ID
    Bloc retrieveBloc(Long idBloc);

    // Supprimer un bloc
    void removeBloc(Long idBloc);

    // Affecter des chambres à un bloc
    Bloc affecterChambresABloc(List<Long> numeroChambre, Long idBloc);
}
