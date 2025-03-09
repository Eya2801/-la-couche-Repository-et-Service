package tn.esprit.tp2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp2.entities.*;
import tn.esprit.tp2.repositories.IChambreRepository;
import tn.esprit.tp2.repositories.IUniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IChambreServicesImpl implements IChambreServices {

    private final IChambreRepository chambreRepository;
    private final IUniversiteRepository universiteRepository;

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> addChambres(List<Chambre> chambres) {
        return chambreRepository.saveAll(chambres);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> updateChambres(List<Chambre> chambres) {
        return chambreRepository.saveAll(chambres);
    }

    @Override
    public void deleteChambre(Chambre chambre) {
        chambreRepository.delete(chambre);
    }

    @Override
    public void deleteChambreById(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        chambreRepository.deleteAll();
    }

    @Override
    public void deleteAll(List<Chambre> chambres) {
        chambreRepository.deleteAll(chambres);
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        chambreRepository.deleteAllById(ids);
    }

    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre findById(Long id) {
        return chambreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chambre not found"));
    }

    @Override
    public long count() {
        return chambreRepository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return chambreRepository.existsById(id);
    }

    @Override
    public List<Chambre> findByNumeroChambre(Long num) {
        return chambreRepository.findByNumeroChambre(num);
    }

    @Override
    public List<Chambre> findByTypeC(TypeChambre type) {
        return chambreRepository.findByTypeC(type);
    }

    @Override
    public List<Chambre> findByBlocIdBloc(Long blocId) {
        return chambreRepository.findByBlocIdBloc(blocId);
    }

    @Override
    public List<Chambre> findByTypeCAndBloc(TypeChambre type, Bloc bloc) {
        return chambreRepository.findByTypeCAndBloc(type, bloc);
    }

    @Override
    public List<Chambre> findByNumeroChambreAndTypeC(Long num, TypeChambre type) {
        return chambreRepository.findByNumeroChambreAndTypeC(num, type);
    }

    @Override
    public List<Chambre> findByNumeroChambreAndBloc(Long num, Bloc bloc) {
        return chambreRepository.findByNumeroChambreAndBloc(num, bloc);
    }

    @Override
    public long countChambreByBlocFoyerNomFoyerAndTypeC(String nomFoy, TypeChambre type) {
        return chambreRepository.countChambreByBlocFoyerNomFoyerAndTypeC(nomFoy, type);
    }

    @Override
    public List<Chambre> getChambreByNomBloc(String nomBloc) {
        return chambreRepository.getChambreByNomBloc(nomBloc);
    }
}
