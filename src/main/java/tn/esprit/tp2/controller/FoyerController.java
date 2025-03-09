package tn.esprit.tp2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp2.entities.Foyer;
import tn.esprit.tp2.services.IFoyerServices;

import java.util.List;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerController {

    IFoyerServices foyerService;

    // Récupérer tous les foyers
    @GetMapping("/retrieveAllFoyers")
    public List<Foyer> getAllFoyers() {
        return foyerService.retrieveAllFoyers();
    }

    // Créer un foyer
    @PostMapping("/createFoyer")
    public Foyer createFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    // Mettre à jour un foyer
    @PutMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    // Récupérer un foyer par son ID
    @GetMapping("/{id}")
    public Foyer getFoyerById(@PathVariable long id) {
        return foyerService.retrieveFoyer(id);
    }

    // Supprimer un foyer par son ID
    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable long id) {
        foyerService.removeFoyer(id);
    }

    // Récupérer un foyer par son nom et sa capacité
    @GetMapping("/getByNomCapacite/{nomFoyer}/{capaciteFoyer}")
    public Foyer getFoyerByNomCapacite(@PathVariable String nomFoyer, @PathVariable Long capaciteFoyer) {
        return foyerService.getNomCapacite(nomFoyer, capaciteFoyer);
    }
}
