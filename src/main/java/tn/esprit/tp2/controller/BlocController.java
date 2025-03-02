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
    @GetMapping("/retrieveallblocs")
    public List<Bloc> getBlocs() {
        return blocServices.retrieveBlocs();
    }

    @GetMapping("/retrievebloc/{blocid}")
    public Bloc retrieveBloc(@PathVariable Long blocid) {
        return blocServices.retrieveBloc(blocid);
    }

    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocServices.addBloc(bloc);
    }

    @DeleteMapping("/removebloc/{blocid}")
    public void removeBloc(@PathVariable Long blocid) {
        blocServices.removeBloc(blocid);
    }




}


