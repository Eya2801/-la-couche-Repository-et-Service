package tn.esprit.tp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp2.entities.Universite;

@Repository
public interface IUniversiteRepository extends JpaRepository<Universite, Long> {

   // Trouver l'université par son nom
   Universite findByUniversiteName(String nomUniversite);
}
