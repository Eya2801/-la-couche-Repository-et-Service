package tn.esprit.tp2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp2.entities.Chambre;
import tn.esprit.tp2.entities.Etudiant;
import tn.esprit.tp2.services.IChambreServices;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {
    IChambreServices chambreServices;

    @GetMapping("/retrieveallchambres")
    public List<Chambre> retrieveAllChambres() {
        return chambreServices.retrieveAllChambres();

    }

    @GetMapping("/retrievechambre/{chambreid}")
    public Chambre retrieveChambre(@PathVariable Long chambreid)  {
        return chambreServices.retrieveChambre(chambreid);
    }


    @PostMapping("/addchambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        return chambreServices.addChambre(c);
    }

    @PutMapping ("/updatechambre")
    public Chambre updateChambre (@RequestBody Chambre c) {
        return chambreServices.updateChambre(c);
    }

    }

