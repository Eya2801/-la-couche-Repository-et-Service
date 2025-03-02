package tn.esprit.tp2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp2.entities.Etudiant;
import tn.esprit.tp2.repositories.IEtudiantRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class IEtudiantServicesImpl implements IEtudiantServices {

   IEtudiantRepository iEtudiantRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return iEtudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return iEtudiantRepository.save(etudiant);
    }


    @Override
    public Etudiant updateEtudiant(Etudiant et) {
        return iEtudiantRepository.save(et);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return iEtudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        iEtudiantRepository.deleteById(idEtudiant);
    }
}
