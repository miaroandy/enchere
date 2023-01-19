package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "rechargement")
public class Rechargement {
    @Id
    @Column(name = "idrechargement")
    private int idrechargement;
    @Column(name = "numerocompte")
    private String numerocompte;
    @Column
    private int montant;
    @Column
    private int etat;

    public Rechargement(int idrechargement, String numerocompte, int montant, int etat) {
        this.idrechargement = idrechargement;
        this.numerocompte = numerocompte;
        this.montant = montant;
        this.etat = etat;
    }

    public Rechargement() {
    }

    public int getIdrechargement() {
        return idrechargement;
    }

    public void setIdrechargement(int idrechargement) {
        this.idrechargement = idrechargement;
    }

    public String getNumerocompte() {
        return numerocompte;
    }

    public void setNumerocompte(String numerocompte) {
        this.numerocompte = numerocompte;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
