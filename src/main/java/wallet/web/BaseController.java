package wallet.web;


import wallet.domain.Client;
import wallet.web.facade.BaseFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api")
public class BaseController {

    @Autowired
    private BaseFacade facade;


    @ResponseBody
    @GetMapping(value = "clients")
    public ResponseEntity<List<Client>> getClients() {
        log.info("Receive GET request /api/clients.");

        List<Client> records = facade.getClients();
        return ResponseEntity.ok(records);
    }

}
