package com.models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@Entity()
@Table(name="produit")
public class Produit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idproduit")
    private int idproduit;
    @Column(name = "nomproduit")
    private String nomproduit;
    @Column(name = "idUtilisateur")
    private int idutilisateur;
    @Column(name = "idcategorie")
    private int idcategorie;
    @Column(name = "descri")
    private String descri;
    @Column(name = "prixenchere")
    private int prixenchere;
    @Column(name = "prixmin")
    private int prixmin;
    @Column(name = "duree")
    private int duree;
    @Column(name = "debut")
    private Date debut;
    @Column(name = "statut")
    private int statut;

    public Produit(int idproduit, String nomproduit, int idUtilisateur, int idcategorie, String descri, int prixenchere, int prixmin, int duree, Date debut, int statut) {
        this.idproduit = idproduit;
        this.nomproduit = nomproduit;
        this.idutilisateur = idUtilisateur;
        this.idcategorie = idcategorie;
        this.descri = descri;
        this.prixenchere = prixenchere;
        this.prixmin = prixmin;
        this.duree = duree;
        this.debut = debut;
        this.statut = statut;
    }

    public Produit() {
    }

    public int getIdUtilisateur() {
        return idutilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idutilisateur = idUtilisateur;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
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

    public boolean isTerminer(){
        Calendar cal=Calendar.getInstance();
        cal.setTime(this.debut);
        Double d=new Double(this.duree);
        cal.add(Calendar.HOUR,d.intValue());
        Date termine= cal.getTime();
        cal=Calendar.getInstance();
        if(cal.getTime().before(termine)==true)
            return false;
        return true;
    }

}
