package com.example.LogiTrack.Service;

import com.example.LogiTrack.Repository.LigneCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LigneCommandeService {
    private final LigneCommandeRepository ligneCommaneRepository;
    @Autowired
    public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommaneRepository = ligneCommandeRepository;
    }




}
