package tn.esprit.tp2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
private Date anneeUniversitaire;
private boolean estValide;

@ManyToMany(mappedBy = "reservations")
   private List<Etudiant> etudiants;

}
