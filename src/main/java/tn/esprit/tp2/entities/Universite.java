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
    private Long idUniversite;
    private String nomUniversite;
    private String address;


    @OneToOne(mappedBy = "université")
    private Foyer foyer;
}
