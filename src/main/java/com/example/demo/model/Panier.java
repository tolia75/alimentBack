package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "pa_panier")
// Annotation qui évite les boucles infinies lors de récupération de d'entités en BDD
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Panier implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private int prix;

    @Column(name = "is_cadeau")
    private boolean isCadeau;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "panier")
    private Set<Aliment> aliments;

    @Override
    public String toString() {
        return "Panier{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", isCadeau=" + isCadeau +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Panier panier = (Panier) o;
        return prix == panier.prix &&
                isCadeau == panier.isCadeau &&
                Objects.equals(id, panier.id) &&
                Objects.equals(nom, panier.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prix, isCadeau);
    }
}
