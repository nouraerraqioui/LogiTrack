package com.example.LogiTrack.Repository;

import com.example.LogiTrack.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
}
