package com.SitemaRPG.SitemaRPG.Models;

import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "/personagem")
public class PersonagemModel {
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

    @Min(0)  @Max(10)
    private int forca;

    @Min(0)  @Max(10)
    private int defesa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeAventureiro() {
        return NomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        NomeAventureiro = nomeAventureiro;
    }

    public ClassePerso getClassePerso() {
        return classePerso;
    }

    public void setClassePerso(ClassePerso classePerso) {
        this.classePerso = classePerso;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public List<ItensMagicoModel> getItensMagicoModels() {
        return itensMagicoModels;
    }

    public void setItensMagicoModels(List<ItensMagicoModel> itensMagicoModels) {
        this.itensMagicoModels = itensMagicoModels;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa)    {
        this.defesa = defesa;
    }

}
