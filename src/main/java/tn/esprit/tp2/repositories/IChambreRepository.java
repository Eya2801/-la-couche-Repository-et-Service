package tn.esprit.tp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tp2.entities.Bloc;
import tn.esprit.tp2.entities.Chambre;
import tn.esprit.tp2.entities.TypeChambre;

import java.util.List;

@Repository
public interface IChambreRepository extends JpaRepository<Chambre, Long> {

  List<Chambre> findByNumchambreIn(List<Long> numeroChambre);

  Chambre getByNumeroChambre(long numeroChambre);
  // 2. Recherche par type de chambre
  List<Chambre> findByTypeC(TypeChambre typeC);

  // 3. Recherche des chambres par bloc
  List<Chambre> findByBlocIdBloc(long blocId);

  // 4. Recherche des chambres par bloc et type de chambre
  List<Chambre> findByTypeCAndBloc(TypeChambre typeC, Bloc bloc);
  // 5. Recherche des chambres par numéro de chambre et type de chambre
  List <Chambre> findByNumeroChambreAndTypeC(long numeroChambre, TypeChambre typeC);

  // 6. Récupérer des chambres en filtrant par le nom de l'université associée au foyer, l'année de réservation,

  // List<Chambre> findByBlocFoyerUniversiteNomUniversiteAndReservationAnneeUniversitaireAndReservationEtsNomEtContainingAndNumeroChambre(String nomUniversite, Date anneeUniversitaire, String nomEtudiant, long numeroChambre);
  List<Chambre> findByNumeroChambreAndBloc(long num, Bloc bloc);

  // 7. Afficher le nombre des chambres qui ont le même type que le type passé en paramètre du foyer
  // qui a le même nom que le nom passé en paramètre
  long countChambreByBlocFoyerNomFoyerAndTypeC(String nomFoy, TypeChambre type);


  List<Chambre> getChambreByNomBloc(String nomBloc);

  //JPQL
  @Query("SELECT c FROM Chambre c WHERE c.bloc.nomBloc = :nomBloc")
  List<Chambre> findChambresByNomBloc(@Param("nomBloc") String nomBloc);


  List<Chambre> findByNumeroChambre(long num);
}

