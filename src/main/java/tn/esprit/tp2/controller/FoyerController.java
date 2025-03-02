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

    @GetMapping("/retrieveallFoyer")
    public List<Foyer> getAllFoyers() {
        return foyerService.retrieveAllFoyers();
    }

    @PostMapping("/createFoyer")
    public Foyer createFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @PutMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @GetMapping("/{id}")
    public Foyer getFoyerById(@PathVariable long id) {
        return foyerService.retrieveFoyer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable long id) {
        foyerService.removeFoyer(id);
    }

    @GetMapping("/getByNomCapacite/{nomFoyer}/{capaciteFoyer}")
    public Foyer getFoyerByNomCapacite(@PathVariable String nomFoyer, @PathVariable Long capaciteFoyer) {
        return foyerService.getNomCapacite(nomFoyer, capaciteFoyer);
    }
}
