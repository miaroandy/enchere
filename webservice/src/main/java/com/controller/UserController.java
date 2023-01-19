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
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    @Autowired
    RechargementService rechargeService;

    @GetMapping("/{userid}")
    private Object getUser(@PathVariable("userid") int userid)
    {
        return userService.getUsersById(userid);
    }


    @PostMapping("/login")
    private Object login(@RequestBody Utilisateur user){
        return userService.login(user);
    }

    @PostMapping("/recharge")
    private void recharge(@RequestBody Rechargement user){
        rechargeService.rechargement(user);
    }

    @PostMapping()
    private int inscription(@RequestBody Utilisateur user){
        userService.saveOrUpdate(user);
        return user.getIduser();
    }

    @GetMapping()
    private Object getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{token}/validation")
    private Object isValide(@PathVariable("token") String token){
        return userService.isValide(token);
    }

    @DeleteMapping("/{token}/deconnexion")
    private void deconnexion(@PathVariable("token") String token){
        tokenService.deconnexion(token);
    }

}
