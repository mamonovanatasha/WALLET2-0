package wallet.logic.service;

import wallet.domain.Client;
import wallet.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public List<Client> findClients() {
        return clientRepository.findAll();
    }
}
