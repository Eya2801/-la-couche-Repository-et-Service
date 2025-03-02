package tn.esprit.tp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp2.entities.Bloc;

@Repository
public interface IBlocRepository extends JpaRepository<Bloc, Long> {
}
