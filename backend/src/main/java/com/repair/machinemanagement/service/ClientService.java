package com.repair.machinemanagement.service;

import com.repair.machinemanagement.dto.ClientRequest;
import com.repair.machinemanagement.entity.Client;
import com.repair.machinemanagement.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepository clientRepository;
    
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
    }
    
    public List<Client> searchClients(String keyword) {
        return clientRepository.findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(keyword, keyword);
    }
    
    public Client createClient(ClientRequest request) {
        if (clientRepository.existsByNumero(request.getNumero())) {
            throw new RuntimeException("Numéro déjà utilisé");
        }
        
        Client client = Client.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .adresse(request.getAdresse())
                .numero(request.getNumero())
                .email(request.getEmail())
                .autres(request.getAutres())
                .build();
        
        return clientRepository.save(client);
    }
    
    public Client updateClient(Long id, ClientRequest request) {
        Client client = getClientById(id);
        
        client.setNom(request.getNom());
        client.setPrenom(request.getPrenom());
        client.setAdresse(request.getAdresse());
        client.setNumero(request.getNumero());
        client.setEmail(request.getEmail());
        client.setAutres(request.getAutres());
        
        return clientRepository.save(client);
    }
    
    public void deleteClient(Long id) {
        Client client = getClientById(id);
        clientRepository.delete(client);
    }
}
