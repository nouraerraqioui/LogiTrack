package com.example.LogiTrack.Servlet;


import com.example.LogiTrack.Model.Commande;
import com.example.LogiTrack.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/commandes")

public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @PostMapping
    public Commande creerCommande(@RequestParam Long clientId) {
        return commandeService.creerCommande(clientId);
    }


    @PostMapping("/{commandeId}/produits")
    public Commande ajouterProduitACommande(
            @PathVariable Long commandeId,
            @RequestParam Long produitId,
            @RequestParam Integer quantite) {

        return commandeService.ajouterProduitACommande(commandeId, produitId, quantite);
    }


    @GetMapping
    public List<Commande> recupererToutesCommandes() {
        return commandeService.recupererToutesCommandes();
    }

    @GetMapping("/{id}")
    public Commande recupererCommande(@PathVariable Long id) {
        return commandeService.recupererCommandeParId(id);
    }


    @PutMapping("/{id}/statut")
    public Commande modifierStatutCommande(
            @PathVariable Long id,
            @RequestBody Map<String, String> statutRequest) {

        String statut = statutRequest.get("statut");
        return commandeService.modifierStatutCommande(id, statut);
    }


    @GetMapping("/client/{clientId}")
    public List<Commande> recupererCommandesParClient(@PathVariable Long clientId) {
        return commandeService.recupererCommandesParClient(clientId);
    }


    }

