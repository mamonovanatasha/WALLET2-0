package wallet.web.facade;

import wallet.domain.Client;
import wallet.logic.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseFacade {

    @Autowired
    private ClientService clientService;


    public List<Client> getClients() {
        return clientService.findClients();
    }
}
