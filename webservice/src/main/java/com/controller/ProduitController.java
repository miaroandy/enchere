package com.controller;

import com.models.Produit;
import com.models.RechercheAvance;
import com.service.ProduitService;
import com.service.RechercheService;
import com.service.VProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @Autowired
    VProduitService vProduitService;

    @Autowired
    RechercheService rechercheService;

    @PostMapping("/recherches")
    private Object getRechercheProduit(@RequestBody RechercheAvance rech){
        return rechercheService.rechercheAvance(rech);
    }

    @GetMapping()
    private Object getAllVProduit() {
        return vProduitService.getAllVProduit();
    }

    @GetMapping("/{produitid}")
    private Object getVProduit(@PathVariable("produitid") int produitid)
    {
        return vProduitService.getVProduitById(produitid);
    }

    @PostMapping()
    private int saveProduit(@RequestBody Produit produit){
        produitService.saveOrUpdate(produit);
        return produit.getIdproduit();
    }

    @DeleteMapping("/{produitid}")
    private void deleteProduit(@PathVariable("produitid") int produitid)
    {
        produitService.delete(produitid);
    }

    @PutMapping()
    private void update(@RequestBody Produit produit)
    {
        produitService.saveOrUpdate(produit);
    }

    @GetMapping("/terminer")
    private void termineProduit()
    {
        produitService.terminerEnchere();
    }

}
