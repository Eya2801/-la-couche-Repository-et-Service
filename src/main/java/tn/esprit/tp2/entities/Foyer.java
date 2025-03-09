package tn.esprit.tp2.entities;


import jakarta.persistence.*;
import lombok.*;

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
    @OneToOne(cascade = CascadeType.ALL)
    private Universite universite;

//one to many avec bloc
    @OneToMany(mappedBy = "foyer")
    @ToString.Exclude

    private List<Bloc> bloc;
}