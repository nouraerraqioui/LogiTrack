package com.example.LogiTrack.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantite;
    @ManyToOne
    @JoinColumn(name = "commande-id")
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "produit-id")
    private Commande commande;

}