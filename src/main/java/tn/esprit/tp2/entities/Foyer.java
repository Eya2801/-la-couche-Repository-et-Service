package tn.esprit.tp2.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;
    ;

    //one to one avec universite
    @OneToOne
    private Universite université;

//one to many avec bloc
    @OneToMany(mappedBy = "foyer")
    private List<Bloc> bloc;
}