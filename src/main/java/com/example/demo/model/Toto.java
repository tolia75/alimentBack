package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@ToString
@Getter
@Setter

@Entity
@Table(name = "toto")
public class Toto implements Serializable {

    @Id
    @Column(name = "id_toto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom_toto")
    private String nom;
}
