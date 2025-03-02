package tn.esprit.tp2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp2.entities.Bloc;
import tn.esprit.tp2.repositories.IBlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IBlocServicesImpl implements IBlocServices {
IBlocRepository blocRepository;
    @Override
    public List<Bloc> retrieveBlocs() {
        return  blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }
}
