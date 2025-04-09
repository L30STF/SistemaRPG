package com.SitemaRPG.SitemaRPG.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personagem")
public class personagemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String NomeAventureiro;

    @Enumerated(EnumType.STRING)
    private ClassePerso classePerso;

    private int Level;

    @OneToMany
    private List<ItensMagicoModel>  itensMagicoModels ;

    private int Força;
    private int defesa;



}
