package fr.limayrac.Camionnette.service;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.limayrac.Camionnette.model.Client;
import fr.limayrac.Camionnette.repository.ClientRepository;
import java.util.Optional;

@Data
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> getClient(final Integer id){
        return clientRepository.findById(id);
    }

    public Iterable<Client> getClients() {
        return clientRepository.findAll();
    }

    public void deleteClient(final Integer id){
        clientRepository.deleteById(id);
    }
    
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }
}
