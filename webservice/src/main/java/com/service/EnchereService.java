package com.service;

import com.models.*;
import com.models.Error;
import com.repository.BloquageRepository;
import com.repository.EnchereRepository;
import com.repository.ProduitRepository;
import com.repository.VEncherePrixMaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnchereService {
    @Autowired
    EnchereRepository enchereRepository;

    @Autowired
    BloquageRepository bloquageRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    VEncherePrixMaxRepository prixMaxRepository;

    public Object encherir(int produitId, Enchere enchere){
        try{
            VEncherePrixMax prixmax=getPrixMaxProduit(produitId);
            if(prixmax!=null && enchere.getPrix()<=prixmax.getPrix()){
                throw new Exception("Prix inférieure à l'enchère précédente");
            }

            enchereRepository.save(enchere);

            Object pdt=produitRepository.findById(produitId);
            Produit produit=(Produit) pdt;
            if(findBloquage(produit.getIdproduit())!=null){
                Bloquage lastBloquage=findBloquage(produit.getIdproduit());
                bloquageRepository.delete(lastBloquage);
            }

            Bloquage nouvelleBloquage=new Bloquage();
            nouvelleBloquage.setIdproduit(produit.getIdproduit());
            nouvelleBloquage.setIdutilisateur(enchere.getIdutilisateur());
            nouvelleBloquage.setPrix(enchere.getPrix());
            bloquageRepository.save(nouvelleBloquage);

            return new Data(true);
        }catch(Exception e){
            return new Error(e);
        }
    }

    private VEncherePrixMax getPrixMaxProduit(int produitid){
        Object o=prixMaxRepository.findById(produitid);
        VEncherePrixMax v=(VEncherePrixMax) o;
        return v;
    }

    public Object getAllEnchere(){
        try{
            List<Enchere> list=new ArrayList<Enchere>();
            enchereRepository.findAll().forEach(enchere -> list.add(enchere));
            return new Data(list);
        }catch(Exception e){
            return new Error(e);
        }
    }

    public Object findById(int idenchere){
        try{
            return new Data(enchereRepository.findById(idenchere).get());
        }catch(Exception e){
            return new Error(e);
        }
    }

    public Object findByIdProduit(int idproduit){
        try{
            List<Enchere> list=new ArrayList<Enchere>();
            enchereRepository.findAll().forEach(enchere -> list.add(enchere));
            List<Enchere> nlist=new ArrayList<Enchere>();
            for(int i=0;i<list.size();i++){
                if(list.get(i).getIdproduit()==idproduit){
                    nlist.add((Enchere) list.get(i));
                }
            }
            return new Data(nlist);
        }catch(Exception e){
            return new Error(e);
        }
    }

    private Bloquage findBloquage(int idproduit){
        Bloquage bl=null;
        List<Bloquage> list=new ArrayList<Bloquage>();
        bloquageRepository.findAll().forEach(bloquage -> list.add(bloquage));
        for(int i=0;i<list.size();i++){
            if(list.get(i).getIdproduit()==idproduit){
                bl=(Bloquage) list.get(i);
                break;
            }
        }
        return bl;
    }

}
