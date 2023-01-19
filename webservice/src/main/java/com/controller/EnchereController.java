package com.controller;

import com.models.Enchere;
import com.service.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/encheres")
public class EnchereController {

    @Autowired
    EnchereService enchereService;

    @PostMapping("/encherir")
    private void encherir(@RequestBody Enchere enchere){
        enchereService.encherir(enchere.getIdproduit(),enchere);
    }

    @GetMapping("/{enchereid}")
    private Object findById(@PathVariable("enchereid") int enchereid){
        return enchereService.findById(enchereid);
    }

    @GetMapping("/byproduit/{produitid}")
    private Object findByIdProduit(@PathVariable("produitid") int produitid){
        return enchereService.findByIdProduit(produitid);
    }





}
