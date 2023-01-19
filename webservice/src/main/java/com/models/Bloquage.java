package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "bloquage")
public class Bloquage {
    @Id
    @Column(name = "idbloquage")
    private int idbloquage;
    @Column(name = "idproduit")
    private int idproduit;
    @Column(name = "idutilisateur")
    private int idutilisateur;
    @Column(name = "prix")
    private int prix;
    @Column(name = "datemise")
    private Date datemise;

    public int getIdbloquage() {
        return idbloquage;
    }

    public void setIdbloquage(int idbloquage) {
        this.idbloquage = idbloquage;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Date getDatemise() {
        return datemise;
    }

    public void setDatemise(Date datemise) {
        this.datemise = datemise;
    }
}
