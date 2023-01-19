package com.service;

import com.models.*;
import com.repository.CommissionRepository;
import com.repository.ProduitRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.Error;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ProduitService {
    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    BloquageService bloquageService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommissionRepository commissionRepository;

    public Object getAllProduit()
    {
        try{
            List<Produit> produit = new ArrayList<Produit>();
            produitRepository.findAll().forEach(produit1 -> produit.add(produit1));
            return new Data(produit);
        }catch (Exception e){
            return new Error(e);
        }
    }

    public Object getProduitById(int id) {
        try {
            return new Data(produitRepository.findById(id).get());
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public void saveOrUpdate(Produit produit)
    {
        produitRepository.save(produit);
    }

    public void delete(int id)
    {
        produitRepository.deleteById(id);
    }

    public void update(Produit produit, int produitid)
    {
        produitRepository.save(produit);
    }

    public void terminerEnchere(){
        try {
            List<Produit> produit = new ArrayList<Produit>();
            produitRepository.findAll().forEach(produit1 -> produit.add(produit1));
            for (int i = 0; i < produit.size(); i++) {
                if (produit.get(i).isTerminer() == true) {
                    produit.get(i).setStatut(1);
                    this.update(produit.get(i), produit.get(i).getIdproduit());
                    Bloquage bloq = bloquageService.getBloquageByIdProduit(produit.get(i).getIdproduit());
                    Float prix=new Float(bloq.getPrix());
                    if(prix<produit.get(i).getPrixenchere()) {
                        bloquageService.delete(bloq);
                        continue;
                    }
                    Utilisateur user=userRepository.findById(bloq.getIdutilisateur()).get();
                    user.setMontant(user.getMontant()-prix.intValue());
                    userRepository.save(user);
                    Utilisateur u=userRepository.findById(produit.get(i).getIdUtilisateur()).get();
                    Commission com=commissionRepository.findById(1).get();
                    prix=prix-(prix*com.getCommission()/100);
                    u.setMontant(u.getMontant()+prix.intValue());
                    userRepository.save(u);
                    bloquageService.delete(bloq);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
