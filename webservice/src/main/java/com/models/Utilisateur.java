package com.models;

import javax.persistence.*;

@Entity(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idutilisateur")
    private int iduser;
    @Column(name = "nomuser")
    private String nomuser;
    @Column(name = "mdp")
    private String mdp;
    @Column(name = "numerocompte")
    private String numerocompte;
    @Column(name="montant")
    private int montant;

    public Utilisateur(int iduser, String nomuser, String mdp, String numerocompte, int montant) {
        this.iduser = iduser;
        this.nomuser = nomuser;
        this.mdp = mdp;
        this.numerocompte = numerocompte;
        this.montant = montant;
    }

    public Utilisateur() {
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNomuser() {
        return nomuser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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
}
