package tn.esprit.tp2.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp2.entities.Etudiant;
import tn.esprit.tp2.services.IEtudiantServices;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Etudiant")
public class EtudiantController {
  IEtudiantServices etudiantServices;
    @GetMapping("/retrieve-all-etudiants")
  public List<Etudiant> getEtudiants() {
        return etudiantServices.retrieveAllEtudiants();
    }

    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable Long idEtudiant) {
        return etudiantServices.retrieveEtudiant(idEtudiant);
    }

    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantServices.addEtudiant(etudiant);
    }
    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant et) {
        return etudiantServices.updateEtudiant(et);
    }
    @DeleteMapping("/remove/{id}")
    public void removeEtudiant(@PathVariable Long idEtudiant) {
        etudiantServices.removeEtudiant(idEtudiant);
    }


}

