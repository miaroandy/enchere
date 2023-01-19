package com.service;

import com.models.Bloquage;
import com.models.Data;
import com.models.Error;
import com.repository.BloquageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BloquageService {
    @Autowired
    BloquageRepository bloquageRepository;

    public Object findAll(){
        try{
            List<Bloquage> list=new ArrayList<Bloquage>();
            bloquageRepository.findAll().forEach(bloquage -> list.add(bloquage));
            return new Data(list);
        }catch(Exception e){
            return new Error(e);
        }
    }

    public Bloquage getBloquageByIdProduit(int idProduit)throws Exception{
        return bloquageRepository.findBloquageByIdproduit(idProduit);
    }

    public Object findById(int idBloquage){
        try{
            return new Data(bloquageRepository.findById(idBloquage));
        }catch(Exception e){
            return new Error(e);
        }
    }

    public void delete(Bloquage bloquage){
        bloquageRepository.delete(bloquage);
    }

    public void saveOrUpdate(Bloquage bloquage)
    {
        bloquageRepository.save(bloquage);
    }
    public void update(Bloquage bloquage, int bloquageid)
    {
        bloquageRepository.save(bloquage);
    }

}
