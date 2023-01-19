package com.models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "v_encheretermine")
public class Resultat {
    @Id
    @Column
    private int idproduit;
    @Column
    private int idutilisateur;
    @Column
    private String nomproduit;
    @Column
    private int idcategorie;
    @Column
    private String descri;
    @Column
    private int prixenchere;
    @Column
    private int prixmin;
    @Column
    private int duree;
    @Column
    private Date debut;
    @Column
    private int statut;
    @Column
    private float commission;
    @Column
    private String nomcategorie;
    @Column
    private int idenchere;
    @Column
    private int  gagnant;
    @Column
    private int prix;
    @Column
    private Date datemise;

    public Resultat() {
    }

    public Resultat(int idproduit, int idutilisateur, String nomproduit, int idcategorie, String descri, int prixenchere, int prixmin, int duree, Date debut, int statut, float commission, String nomcategorie, int idenchere, int gagnant, int prix, Date datemise) {
        this.idproduit = idproduit;
        this.idutilisateur = idutilisateur;
        this.nomproduit = nomproduit;
        this.idcategorie = idcategorie;
        this.descri = descri;
        this.prixenchere = prixenchere;
        this.prixmin = prixmin;
        this.duree = duree;
        this.debut = debut;
        this.statut = statut;
        this.commission = commission;
        this.nomcategorie = nomcategorie;
        this.idenchere = idenchere;
        this.gagnant = gagnant;
        this.prix = prix;
        this.datemise = datemise;
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

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public int getPrixenchere() {
        return prixenchere;
    }

    public void setPrixenchere(int prixenchere) {
        this.prixenchere = prixenchere;
    }

    public int getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(int prixmin) {
        this.prixmin = prixmin;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public String getNomcategorie() {
        return nomcategorie;
    }

    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    public int getIdenchere() {
        return idenchere;
    }

    public void setIdenchere(int idenchere) {
        this.idenchere = idenchere;
    }

    public int getGagnant() {
        return gagnant;
    }

    public void setGagnant(int gagnant) {
        this.gagnant = gagnant;
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
