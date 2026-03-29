package com.example.LogiTrack.Service;

import com.example.LogiTrack.Model.Produit;
import com.example.LogiTrack.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Produit " + id + " n'existe pas"));
    }

    public void deleteProduit(Long id) {
        if (!produitRepository.existsById(id)) {
            throw new IllegalStateException("Produit " + id + " n'existe pas");
        }
        produitRepository.deleteById(id);
    }

    public List<Produit> findByCategorie(String categorie) {
        return produitRepository.findByCategorie(categorie);
    }

    public List<Produit> findByPrixLessThan(Double prix) {
        return produitRepository.findByPrixLessThan(prix);
    }

    public List<Produit> lowStock() {
        return produitRepository.lowStock();
    }
}