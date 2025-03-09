package tn.esprit.tp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp2.entities.Etudiant;

import java.util.Optional;

@Repository
public interface
IEtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByCinEtudiant(Long cinEtudiant);

}
