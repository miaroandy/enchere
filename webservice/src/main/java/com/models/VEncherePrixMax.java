package com.models;

import javax.persistence.*;

@Entity()
@Table(name="v_enchereprixmax")
public class VEncherePrixMax {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idproduit;
    @Column(name="prix")
    private int prix;

    public VEncherePrixMax(int idproduit, int prix) {
        this.idproduit = idproduit;
        this.prix = prix;
    }

    public VEncherePrixMax() {
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
