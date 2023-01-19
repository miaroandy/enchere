package com.service;

import com.models.Data;
import com.models.Error;
import com.models.VEncherePrixMax;
import com.repository.VEncherePrixMaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VEncherePrixMaxService {
    @Autowired
    VEncherePrixMaxRepository repository;

    public Object findAll(){
        try{
            List<VEncherePrixMax> list=new ArrayList<VEncherePrixMax>();
            repository.findAll().forEach(vEncherePrixMax -> list.add(vEncherePrixMax));
            return new Data(list);
        }catch (Exception e){
            return new Error(e);
        }
    }

    public Object findById(int produitid){
        try{
            return new Data(repository.findById(produitid));
        }catch(Exception e){
            return new Error(e);
        }
    }
}
