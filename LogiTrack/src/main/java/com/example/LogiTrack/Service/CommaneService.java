package com.example.LogiTrack.Service;

import com.example.LogiTrack.Repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommaneService {
    private final CommandeRepository commandeRepository;
@Autowired
    public CommaneService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

}
