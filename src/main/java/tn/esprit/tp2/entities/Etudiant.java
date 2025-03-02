package tn.esprit.tp2.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter

public class Etudiant {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idEtudiant;
  private String nomEtudiant;
  private String prenomEtudiant;
  private Long cin;
  private String ecole;
  private Date dateNaissance;

  @ManyToMany
  private List<Reservation> reservations;
}
