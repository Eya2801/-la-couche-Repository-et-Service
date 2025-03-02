package tn.esprit.tp2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp2.entities.Universite;
import tn.esprit.tp2.services.IUniversiteServices;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")

public class UniversiteController {
     IUniversiteServices universiteServices;


    @GetMapping("/retrievealluniversites")
    public List<Universite> getUniversites() {
        return universiteServices.retrieveAllUniversities();
    }


    @GetMapping("/retrieveuniversite/{universiteid}")
    public Universite retrieveUniversite(@PathVariable Long idUniversite) {
        return universiteServices.retrieveUniversite(idUniversite);
    }

    @PostMapping("/adduniversite")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteServices.addUniversite(u);
    }


    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite u)  {
        return  universiteServices.updateUniversite(u);
    }


}
