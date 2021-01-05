package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@ToString
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "al_aliment")
public class Aliment {
    @Id
    @Column(name = "id_aliment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nom_aliment")
    private String nom;
    @Column(name = "type_aliment")
    //@NotEmpty(message = "Le type d'aliment doit être présent")
    private String typeAliment;
    @ManyToOne
    @JoinColumn(name = "panier_fk")
    private Panier panier;

    public Aliment(Long id, String nom, String typeAliment) {
        this.id = id;
        this.nom = nom;
        this.typeAliment = typeAliment;
    }
}
