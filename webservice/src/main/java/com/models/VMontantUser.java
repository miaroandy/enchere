package com.models;

import javax.persistence.*;

@Entity()
@Table(name="v_montant_user")
public class VMontantUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idutilisateur;
    @Column(name="montant")
    private int montant;

    public VMontantUser() {
    }

    public VMontantUser(int idutilisateur, int montant) {
        this.idutilisateur = idutilisateur;
        this.montant = montant;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
