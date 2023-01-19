package com.controller;

import com.service.Statistique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/statistiques")
public class StatistiqueController {

    @Autowired
    private Statistique stat;

    @GetMapping("/CAclient")
    private Object getCAclient(){
        return stat.caclient();
    }

    @GetMapping("/CAcategorie")
    private Object getCACategories(){
        return stat.cacategorie();
    }

    @GetMapping("/produitMax")
    private Object getProduitMax(){
        return stat.produitSort(1);
    }

    @GetMapping("/produitMin")
    private Object getProduitMin(){
        return stat.produitSort(0);
    }

    @GetMapping("/bestCategorie")
    private Object getBestCategorie(){
        return stat.categorieSort(1);
    }

    @GetMapping("/badCategorie")
    private Object getBadCategorie(){
        return stat.categorieSort(0);
    }

}
