package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "al_aliment")
// Annotation qui évite les boucles infinies lors de récupération de d'entités en BDD
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Aliment implements Serializable {
    @Id
    @Column(name = "id_aliment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nom_aliment")
    private String nom;
    @Column(name = "type_aliment")
    //@NotEmpty(message = "Le type d'aliment doit être présent")
    private String typeAliment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "panier_fk")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Panier panier;

    public Aliment(Long id, String nom, String typeAliment) {
        this.id = id;
        this.nom = nom;
        this.typeAliment = typeAliment;
    }

    @Override
    public String toString() {
        return "Aliment{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", typeAliment='" + typeAliment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aliment aliment = (Aliment) o;
        return Objects.equals(id, aliment.id) &&
                Objects.equals(nom, aliment.nom) &&
                Objects.equals(typeAliment, aliment.typeAliment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, typeAliment);
    }
}
