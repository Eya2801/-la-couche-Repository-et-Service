package tn.esprit.tp2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp2.entities.Bloc;
import tn.esprit.tp2.entities.Foyer;
import tn.esprit.tp2.entities.Universite;
import tn.esprit.tp2.repositories.IBlocRepository;
import tn.esprit.tp2.repositories.IFoyerRepository;
import tn.esprit.tp2.repositories.IUniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IFoyerServicesImpl implements IFoyerServices {

    private final IFoyerRepository foyerRepository;
    private final IUniversiteRepository universiteRepository;
    private final IBlocRepository blocRepository;

    @Override
    public Foyer findByid(long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> findAll() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer save(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void delete(Foyer foyer) {
        foyerRepository.delete(foyer);
    }

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer getNomCapacite(String nomFoyer, Long capaciteFoyer) {
        return foyerRepository.findByNomFoyerAndCapaciteFoyer(nomFoyer, capaciteFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        foyer = foyerRepository.save(foyer);

        // Affecter les blocs au foyer si présents
        if (foyer.getBloc() != null) {
            for (Bloc bloc : foyer.getBloc()) {
                bloc.setFoyer(foyer);
                blocRepository.save(bloc);
            }
        }

        Universite universite = universiteRepository.findById(idUniversite).orElseThrow(() -> new IllegalArgumentException("Université non trouvée"));
        universite.setFoyer(foyer);
        universiteRepository.save(universite);

        return foyer;
    }
}
