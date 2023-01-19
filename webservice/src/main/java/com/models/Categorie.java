package com.models;

import javax.persistence.*;

@Entity(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategorie")
    private int idcategorie;
    @Column(name = "nomcategorie")
    private String nomcategorie;


    public Categorie(){}

    public Categorie(int idcategorie, String nomCategorie) {
        this.idcategorie = Categorie.this.idcategorie;
        this.nomcategorie = nomCategorie;
    }

    public int getIdcategorie() {
        return idcategorie;
    }


    public void setIdcategorie(int idcategorie) {
        this.idcategorie = Categorie.this.idcategorie;
    }

    public String getNomCategorie() {
        return nomcategorie;
    }

    public void setNomCategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }
}
