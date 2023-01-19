package com.models;

import java.util.Date;

public class RechercheAvance {
    private int idcategorie;
    private int prixMin;
    private Date date;
    private int statut;
    private String keyWord;

    public RechercheAvance() {
    }

    public RechercheAvance(int idcategorie, int prixMin, Date date, int statut, String keyWord) {
        this.idcategorie = idcategorie;
        this.prixMin = prixMin;
        this.date = date;
        this.statut = statut;
        this.keyWord = keyWord;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public int getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(int prixMin) {
        this.prixMin = prixMin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
