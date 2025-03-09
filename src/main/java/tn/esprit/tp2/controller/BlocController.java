package tn.esprit.tp2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp2.entities.Bloc;
import tn.esprit.tp2.services.IBlocServices;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {
    IBlocServices blocServices;

    // Récupérer tous les blocs
    @GetMapping("/retrieveallblocs")
    public List<Bloc> getBlocs() {
        return blocServices.retrieveBlocs();
    }

    // Récupérer un bloc par son ID
    @GetMapping("/retrievebloc/{blocid}")
    public Bloc retrieveBloc(@PathVariable Long blocid) {
        return blocServices.retrieveBloc(blocid);
    }

    // Ajouter un bloc
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocServices.addBloc(bloc);
    }

    // Supprimer un bloc par son ID
    @DeleteMapping("/removebloc/{blocid}")
    public void removeBloc(@PathVariable Long blocid) {
        blocServices.removeBloc(blocid);
    }

    // Affecter des chambres à un bloc
    @PostMapping("/affecterchambre/{idbloc}")
    public Bloc affecterChambresABloc(@PathVariable Long idbloc, @RequestBody List<Long> numeroChambre) {
        return blocServices.affecterChambresABloc(numeroChambre, idbloc);
    }
}
