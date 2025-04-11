package com.SitemaRPG.SitemaRPG.Models;


import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "/ItemMagico")
public class ItensMagicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Nome;

    @Min(0) @Max(10)
    private int forca;

    @Min(0) @Max(10)
    private int Defesa;

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

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return Defesa;
    }

    public void setDefesa(int defesa) {
        this.Defesa = defesa;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }


}
