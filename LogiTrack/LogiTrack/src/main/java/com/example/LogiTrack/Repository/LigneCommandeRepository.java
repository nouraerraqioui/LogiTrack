package com.example.LogiTrack.Repository;

import com.example.LogiTrack.Model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {
}
