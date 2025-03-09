package tn.esprit.tp2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.tp2.entities.Chambre;
import tn.esprit.tp2.entities.Universite;
import tn.esprit.tp2.services.IUniversiteServices;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {

    private final IUniversiteServices universiteServices;

    // Récupérer toutes les universités
    @GetMapping("/retrieveAllUniversites")
    public List<Universite> getUniversites() {
        return universiteServices.retrieveAllUniversities();
    }

    // Récupérer une université par son ID
    @GetMapping("/retrieveUniversite/{universiteid}")
    public Universite retrieveUniversite(@PathVariable Long universiteid) {
        return universiteServices.retrieveUniversite(universiteid);
    }

    // Ajouter une nouvelle université
    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteServices.addUniversite(u);
    }

    // Mettre à jour une université
    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite u) {
        return universiteServices.updateUniversite(u);
    }

    // Affecter un foyer à une université
    @PostMapping("/affecterFoyerUniversite/{universitenom}/{idfoyer}")
    public Universite affecterFoyerAUniversite(@PathVariable Long idFoyer, @PathVariable String universitenom) {
        return universiteServices.affecterFoyerAUniversite(idFoyer, universitenom);
    }

    // Désaffecter un foyer d'une université
    @PostMapping("/desafecterFoyerAuUniversite/{idUniversite}")
    public Universite desafecterFoyerAUniversite(@PathVariable Long idUniversite) {
        return universiteServices.desaffecterFoyerAUniversite(idUniversite);
    }

    // Récupérer les chambres par nom d'université
    @GetMapping("/getChambresParNomUniversite")
    public List<Chambre> getChambresParNomUniversite(@RequestParam String nomUniversite) {
        return universiteServices.getChambresParNomUniversite(nomUniversite);
    }
}
