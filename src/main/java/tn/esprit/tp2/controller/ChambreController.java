package tn.esprit.tp2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp2.entities.Chambre;
import tn.esprit.tp2.services.IChambreServices;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {

    private final IChambreServices chambreServices;

    @PostMapping("addChambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreServices.addChambre(chambre);
    }

    @PostMapping("addChambres")
    public List<Chambre> addChambres(@RequestBody List<Chambre> chambres) {
        return chambreServices.addChambres(chambres);
    }

    @PutMapping("updateChambre")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreServices.updateChambre(chambre);
    }

    @PutMapping("updateChambres")
    public List<Chambre> updateChambres(@RequestBody List<Chambre> chambres) {
        return chambreServices.updateChambres(chambres);
    }

    @DeleteMapping("deleteChambre")
    public void deleteChambre(@RequestBody Chambre chambre) {
        chambreServices.deleteChambre(chambre);
    }

    @DeleteMapping("deleteChambreById")
    public void deleteChambreById(@RequestParam Long id) {
        chambreServices.deleteChambreById(id);
    }

    @DeleteMapping("deleteAllChambre")
    public void deleteAll() {
        chambreServices.deleteAll();
    }

    @DeleteMapping("deleteAllChambres")
    public void deleteAll(@RequestBody List<Chambre> chambres) {
        chambreServices.deleteAll(chambres);
    }

    @DeleteMapping("deleteAllChambreById")
    public void deleteAllById(@RequestParam List<Long> ids) {
        chambreServices.deleteAllById(ids);
    }

    @GetMapping("findAllChambres")
    public List<Chambre> findAll() {
        return chambreServices.findAll();
    }

    @GetMapping("findChambreById")
    public Chambre findById(@RequestParam Long id) {
        return chambreServices.findById(id);
    }

    @GetMapping("countChambre")
    public long count() {
        return chambreServices.count();
    }

    @GetMapping("existsChambreById")
    public boolean existsById(@RequestParam Long id) {
        return chambreServices.existsById(id);
    }
}
