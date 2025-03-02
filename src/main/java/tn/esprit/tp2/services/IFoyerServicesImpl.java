package tn.esprit.tp2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp2.entities.Foyer;
import tn.esprit.tp2.repositories.IFoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IFoyerServicesImpl implements IFoyerServices {
    IFoyerRepository foyerRepository;


    @Override
    public Foyer findByid(long id) {
        return foyerRepository.findById(id).get();
    }

    @Override
    public List<Foyer> findAll() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer save(Foyer foyer) {
        foyerRepository.save(foyer);
        return foyer;
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


}