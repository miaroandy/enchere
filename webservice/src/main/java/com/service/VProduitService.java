package com.service;

import com.models.Data;
import com.models.VProduit;
import com.repository.VProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VProduitService {
    @Autowired
    VProduitRepository vproduitRepository;

    public Object getAllVProduit()
    {
        try{
            List<VProduit> vproduit = new ArrayList<VProduit>();
            vproduitRepository.findAll().forEach(produit1 -> vproduit.add(produit1));
            return new Data(vproduit);
        }catch (Exception e){
            return new Error(e);
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
