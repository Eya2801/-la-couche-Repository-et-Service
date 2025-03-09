package tn.esprit.tp2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idUniversite;
    private String nomUniversite;
    private String address;


    @OneToOne(mappedBy = "universite")
    private Foyer foyer;


}
