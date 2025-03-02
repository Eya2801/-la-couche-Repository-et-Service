package tn.esprit.tp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import tn.esprit.tp2.entities.Foyer;
@Repository


public interface IFoyerRepository extends JpaRepository<Foyer,Long> {


    Foyer findByNomFoyerAndCapaciteFoyer(String nomFoyer, Long capaciteFoyer);


}
