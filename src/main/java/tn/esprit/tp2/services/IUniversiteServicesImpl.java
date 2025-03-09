package tn.esprit.tp2.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.tp2.entities.Chambre;
import tn.esprit.tp2.entities.Foyer;
import tn.esprit.tp2.entities.Universite;
import tn.esprit.tp2.repositories.IBlocRepository;
import tn.esprit.tp2.repositories.IChambreRepository;
import tn.esprit.tp2.repositories.IFoyerRepository;
import tn.esprit.tp2.repositories.IUniversiteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IUniversiteServicesImpl implements IUniversiteServices {

    private final IUniversiteRepository universiteRepository;
    private final IFoyerRepository foyerRepository;
    private final IChambreRepository chambreRepository;
    private final IBlocRepository blocRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Université introuvable")
        );
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = universiteRepository.findByUniversiteName(nomUniversite);
        if (universite == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Université introuvable");
        }

        Foyer foyer = foyerRepository.findById(idFoyer).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Foyer introuvable")
        );

        universite.setFoyer(foyer);
        universiteRepository.save(universite);
        return universite;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Université introuvable")
        );

        universite.setFoyer(null);
        universiteRepository.save(universite);
        return universite;
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        Universite universite = universiteRepository.findByUniversiteName(nomUniversite);
        if (universite == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Université introuvable");
        }

        return universite.getFoyer().getBloc().stream()
                .flatMap(bloc -> bloc.getChambre().stream())
                .collect(Collectors.toList());
    }
}
