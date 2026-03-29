package com.example.LogiTrack.Service;


import com.example.LogiTrack.Model.Client;
import com.example.LogiTrack.Model.Commande;
import com.example.LogiTrack.Model.LigneCommande;
import com.example.LogiTrack.Model.Produit;
import com.example.LogiTrack.Repository.ClientRepository;
import com.example.LogiTrack.Repository.CommandeRepository;
import com.example.LogiTrack.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class CommandeService {

    private static final List<String> STATUTS_VALIDES =
            Arrays.asList("EN_ATTENTE", "EXPEDIEE", "LIVREE");

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Transactional
    public Commande creerCommande(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        Commande commande = new Commande();
        commande.setClient(client);
        commande.setStatus("EN_ATTENTE");

        return commandeRepository.save(commande);
    }

    @Transactional
    public Commande ajouterProduitACommande(Long commandeId, Long produitId, Integer quantite) {
        Commande commande = commandeRepository.findById(commandeId)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));

        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

        if (produit.getQuantiteStock() < quantite) {
            throw new RuntimeException("Stock insuffisant");
        }

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setCommande(commande);
        ligneCommande.setProduit(produit);
        ligneCommande.setQuantite(quantite);

        produit.setQuantiteStock(produit.getQuantiteStock() - quantite);
        produitRepository.save(produit);

        commande.getLignes().add(ligneCommande);
        return commandeRepository.save(commande);
    }

    public List<Commande> recupererToutesCommandes() {
        return commandeRepository.findAll();
    }

    public Commande recupererCommandeParId(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));
    }

    @Transactional
    public Commande modifierStatutCommande(Long id, String statut) {
        Commande commande = recupererCommandeParId(id);
        commande.setStatus(statut);
        return commandeRepository.save(commande);
    }



    public List<Commande> recupererCommandesParClient(Long clientId) {
        return commandeRepository.findByClientId(clientId);
    }




}