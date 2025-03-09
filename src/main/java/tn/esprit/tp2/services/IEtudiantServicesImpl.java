
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

    // Récupérer tous les étudiants
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return iEtudiantRepository.findAll();
    }

    // Ajouter un étudiant
    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return iEtudiantRepository.save(etudiant);
    }

    // Mettre à jour un étudiant
    @Override
    public Etudiant updateEtudiant(Etudiant et) {
        return iEtudiantRepository.save(et);
    }

    // Récupérer un étudiant par son ID
    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return iEtudiantRepository.findById(idEtudiant).orElse(null);
    }

    // Supprimer un étudiant
    @Override
    public void removeEtudiant(Long idEtudiant) {
        iEtudiantRepository.deleteById(idEtudiant);
    }
}
