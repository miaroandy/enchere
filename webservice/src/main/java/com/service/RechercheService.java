package com.service;

import com.models.Data;
import com.models.RechercheAvance;
import com.models.VProduit;
import com.repository.VProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RechercheService {
    @Autowired
    VProduitRepository vproduitRepository;


    public List<VProduit> getAllVProduit()throws Exception
    {
        try{
            List<VProduit> vproduit = new ArrayList<VProduit>();
            vproduitRepository.findAll().forEach(produit1 -> vproduit.add(produit1));
            return vproduit;
        }catch (Exception e){
            throw e;
        }
    }

    public Object getVProduitById(int id) {
        try {
            return new Data(vproduitRepository.findById(id).get());
        }
        catch (Exception e){
            return new Error(e);
        }
    }

// get vproduit by id categorie
    public void getVProduitByIdCategorie(int idCategorie,List<VProduit> vproduit) {
        try {
            for (int i = 0; i < vproduit.size(); i++) {
                if(vproduit.get(i).getIdcategorie()==idCategorie)
                    continue;
                vproduit.remove(i);
                i--;
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    public Object rechercheAvance(RechercheAvance rech){
        try {
            List<VProduit> produit = this.getAllVProduit();
            if(rech.getIdcategorie()!=0)
                this.getVProduitByIdCategorie(rech.getIdcategorie(), produit);
            if(rech.getPrixMin()!=0)
                this.getVProduitByPrix(rech.getPrixMin(),produit);
            if(rech.getDate()!=null)
                this.getVProduitByDate(rech.getDate(),produit);
            this.getVProduitByStatut(rech.getStatut(),produit);
            if(rech.getKeyWord()!=null)
                this.getVProduitByMotCle(rech.getKeyWord(),produit);
            return new Data(produit);
        }
        catch (Exception e){
            return new Error(e);
        }
    }


//get vproduit by    prixminimum
    public void getVProduitByPrix(int prix,List<VProduit> vproduit)throws Exception {
        try {
            for (int i = 0; i < vproduit.size(); i++) {
                if(vproduit.get(i).getPrixmin()<=prix)
                    continue;
                vproduit.remove(i);
                i--;
            }
        }
        catch (Exception e){
            throw e;
        }
    }

//get vproduit by date
    public void getVProduitByDate(Date date,List<VProduit> vproduit)throws Exception {
    try {
        for (int i = 0; i < vproduit.size(); i++) {
            if(date.before(vproduit.get(i).getDebut())==true)
                continue;
            vproduit.remove(i);
            i--;
        }
    }
    catch (Exception e){
        throw e;
    }
}

    //get vproduit by statut
    public void getVProduitByStatut(int statut,List<VProduit> vproduit)throws Exception {
        try {
            for (int i = 0; i < vproduit.size(); i++) {
                if(vproduit.get(i).getStatut()==statut)
                    continue;
                vproduit.remove(i);
                i--;
            }
        }
        catch (Exception e){
            throw e;
        }
    }
    //get vproduit by mot cle
    public void getVProduitByMotCle(String keyWord,List<VProduit> vproduit)throws Exception {
        try {
            for (int i = 0; i < vproduit.size(); i++) {
                if(vproduit.get(i).getDescri().compareToIgnoreCase(keyWord)==0)
                    continue;
                vproduit.remove(i);
                i--;
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    public Object getVProduitByIdUtilisateur(int id) {
        try {
            List<VProduit> vproduit = new ArrayList<VProduit>();
            vproduitRepository.findAll().forEach(produit1 -> vproduit.add(produit1));
            for (int i = 0; i < vproduit.size(); i++) {
                if(vproduit.get(i).getIdUtilisateur()==id)
                    continue;
                vproduit.remove(i);
                i--;
            }
            return new Data(vproduit);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

}

