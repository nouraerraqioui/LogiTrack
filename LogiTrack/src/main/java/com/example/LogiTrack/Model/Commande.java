package com.example.LogiTrack.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dateCommande;
    private String status;

    public Commande(int id, LocalDate dateCommande, String status) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.status = status;
    }

    public Commande() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
