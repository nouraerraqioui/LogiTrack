package com.example.LogiTrack.Servlet;

import com.example.LogiTrack.Model.Produit;
import com.example.LogiTrack.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @PostMapping
    public Produit addProduit(@RequestBody Produit produit){
        return produitService.addProduit(produit);
    }

    @GetMapping
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable Long id){
        return produitService.getProduitById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id){
        produitService.deleteProduit(id);
    }

    @GetMapping("/category/{categorie}")
    public List<Produit> getByCategory(@PathVariable String categorie){
        return produitService.findByCategorie(categorie);
    }

    @GetMapping("/price/{prix}")
    public List<Produit> getByPrice(@PathVariable double prix){
        return produitService.findByPrixLessThan(prix);
    }

    @GetMapping("/low-stock")
    public List<Produit> getLowStockProducts(){
        return produitService.lowStock();
    }
}