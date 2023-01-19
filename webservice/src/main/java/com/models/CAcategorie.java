package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "v_cacategorie")
public class CAcategorie {
    @Id
    @Column
    private int idcategorie;
    @Column
    private String nomcategorie;
    @Column
    private int sum;

    public CAcategorie() {
    }

    public CAcategorie(int idcategorie, String nomcategorie, int sum) {
        this.idcategorie = idcategorie;
        this.nomcategorie = nomcategorie;
        this.sum = sum;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getNomcategorie() {
        return nomcategorie;
    }

    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
