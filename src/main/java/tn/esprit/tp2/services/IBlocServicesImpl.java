package tn.esprit.tp2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp2.entities.Bloc;
import tn.esprit.tp2.entities.Chambre;
import tn.esprit.tp2.repositories.IBlocRepository;
import tn.esprit.tp2.repositories.IChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IBlocServicesImpl implements IBlocServices {
    IBlocRepository blocRepository;
    IChambreRepository chambreRepository;

    // Récupérer tous les blocs
    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepository.findAll();
    }

    // Mettre à jour un bloc
    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    // Ajouter un bloc
    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    // Récupérer un bloc par son ID
    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    // Supprimer un bloc
    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    // Affecter des chambres à un bloc
    @Override
    public Bloc affecterChambresABloc(List<Long> numeroChambre, Long idBloc) {
        List<Chambre> chambres = chambreRepository.findByNumchambreIn(numeroChambre); // Récupérer les chambres par leurs numéros

        if (chambres.isEmpty()) {
            throw new IllegalArgumentException("Aucune chambre trouvée avec les numéros spécifiés");
        }

        Bloc bloc = blocRepository.findById(idBloc).orElseThrow(() -> new IllegalArgumentException("Bloc non trouvé"));

        chambres.forEach(chambre -> chambre.setBloc(bloc));
        chambreRepository.saveAll(chambres);

        return bloc;
    }
}
