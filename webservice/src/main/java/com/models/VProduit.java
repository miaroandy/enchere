package com.models;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name="v_produit")
public class VProduit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idproduit;
    @Column
    private String nomproduit;
    @Column(name = "idutilisateur")
    private int idutilisateur;
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
    private String nomcategorie;

    public VProduit(int idproduit, String nomproduit, int idUtilisateur, int idcategorie, String descri, int prixenchere, int prixmin, int duree, Date debut, int statut, String nomcategorie) {
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
        this.nomcategorie = nomcategorie;
    }

    public VProduit() {
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

    public int getIdUtilisateur() {
        return idutilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idutilisateur = idUtilisateur;
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

    public String getNomcategorie() {
        return nomcategorie;
    }

    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }
}
