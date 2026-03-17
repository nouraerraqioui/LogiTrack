package com.example.LogiTrack.Repository;

import com.example.LogiTrack.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Integer> {
}
