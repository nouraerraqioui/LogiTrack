package com.example.LogiTrack.Service;

import com.example.LogiTrack.Model.Client;
import com.example.LogiTrack.Repository.ClientRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
  @PostMapping("/api/clients")
    public void AjouterClient(Client client){
         clientRepository.save(client);
  }
  @GetMapping(" /api/clients")
    public List<Client> AfficherClients(){
        return clientRepository.findAll();
  }
  @GetMapping("/api/clients/{id}")
    public Optional<Client> ConsulterClient(int id){
        return clientRepository.findById(id);
  }
    public void SupprimerClient(int id) {
    boolean exist = clientRepository.existsById(id);
    if (!exist) {
        System.out.println("le client n'existe pas");
    } else {
        clientRepository.deleteById(id);
    }

}

}

