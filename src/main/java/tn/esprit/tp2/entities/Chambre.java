package tn.esprit.tp2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long num;
    private int capaciteMax;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;
    @ManyToOne
    private Bloc bloc;
    //unidirectionnel
    @OneToMany
    private Set<Reservation> reservations;



}

