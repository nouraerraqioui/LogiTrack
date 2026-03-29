
package com.example.LogiTrack.Service;

import com.example.LogiTrack.Model.Client;
import com.example.LogiTrack.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

        @Service
        public class ClientService {

            @Autowired
            private ClientRepository clientRepository;


            public Client addClient(Client client) {
                return clientRepository.save(client);
            }


            public List<Client> getAllClients() {
                return clientRepository.findAll();
            }


            public Client getClientById(Long id) {
                return clientRepository.findById(id)
                        .orElseThrow(() -> new IllegalStateException("Client " + id + " n'existe pas"));
            }


            public void deleteClient(Long id) {
                clientRepository.deleteById(id);
            }
        }





