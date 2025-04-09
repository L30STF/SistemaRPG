package com.SitemaRPG.SitemaRPG.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "ItemMagico")
public class ItensMagicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Nome;
    private int Força;
    private int defesa;

    @Enumerated(EnumType.STRING)
    private TipoItem  tipoItem;

    public ItensMagicoModel() {}

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getForça() {
        return Força;
    }

    public void setForça(int força) {
        Força = força;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }
}
