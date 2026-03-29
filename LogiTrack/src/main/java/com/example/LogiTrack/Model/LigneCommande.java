package com.example.LogiTrack.Model;

import jakarta.persistence.*;

@Entity
@Table
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantite;
}
