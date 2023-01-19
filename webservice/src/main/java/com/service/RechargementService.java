package com.service;

import com.models.*;
import com.models.Error;
import com.repository.RechargementRepository;
import com.repository.VRechargementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RechargementService {
    @Autowired
    RechargementRepository repository;

    @Autowired
    VRechargementRepository vrepository;

    public void rechargement(Rechargement rec){
        rec.setEtat(0);
        repository.save(rec);
    }

    public Object findAll(){
        try {
            List<VRechargement> user = new ArrayList<VRechargement>();
            vrepository.findAll().forEach(user1 -> user.add(user1));
            return new Data(user);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public void validaton(Rechargement rec){
        rec.setEtat(1);
        repository.save(rec);
    }

    public Object findEtat(int etat){
        try {
            List<VRechargement> user = new ArrayList<VRechargement>();
            vrepository.findAll().forEach(user1 -> user.add(user1));
            for (int i = 0; i < user.size(); i++) {
                if(user.get(i).getEtat()==etat){
                    continue;
                }
                user.remove(user.get(i));
                i--;
            }
            return new Data(user);
        }
        catch (Exception e){
            return new Error(e);
        }
    }
}
