package com.controller;

import com.models.Data;
import com.models.Error;
import com.models.Rechargement;
import com.service.RechargementService;
import com.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.service.UserService;
import com.models.Utilisateur;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recharge")
public class ValidationRechargeController {

    @Autowired
    RechargementService rechargeService;

    @Autowired
    UserService userService;

    @GetMapping()
    private Object getRechargement()
    {
        return rechargeService.findAll();
    }

    @GetMapping("/validation/{etat}")
    private Object findEtat(@PathVariable("etat") int etat)
    {
        return rechargeService.findEtat(etat);
    }

    @PutMapping()
    private void validation(@RequestBody Rechargement rec){
        rechargeService.validaton(rec);
        try {
            Utilisateur user = userService.getUsersByCompte(rec.getNumerocompte());
            user.setMontant(user.getMontant()+rec.getMontant());
            userService.update(user,user.getIduser());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
