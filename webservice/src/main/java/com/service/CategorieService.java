package com.service;

import com.models.Categorie;
import com.models.Data;
import com.models.Error;
import com.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieService {

    @Autowired
    CategorieRepository repository;

    public Object getAllCategorie(){
        try {
            final List<Categorie> categorie = new ArrayList<Categorie>();
            repository.findAll().forEach(categorie1 -> categorie.add(categorie1));
            return new Data(categorie);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public Object getCategorie(int id){
        try {
            return new Data(repository.findById(id).get());
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public void updateCategorie(Categorie categorie)
    {
        repository.save(categorie);
    }
}
