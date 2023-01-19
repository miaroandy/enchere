package com.controller;

import com.models.Categorie;
import com.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    @GetMapping
    private Object getAllCategories(){
        return categorieService.getAllCategorie();
    }

    @GetMapping("/{categorieid}")
    private Object getCategorie(@PathVariable("categorieid") int categorieid)
    {
        return categorieService.getCategorie(categorieid);
    }

    @PutMapping()
    private void updateCategorie(@RequestBody Categorie categorie){
        categorieService.updateCategorie(categorie);
    }
}
