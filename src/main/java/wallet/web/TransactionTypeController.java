package wallet.web;

import wallet.domain.TransactionType;
import wallet.web.facade.TransactionTypeFacade;
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
public class TransactionTypeController {
    @Autowired
    private TransactionTypeFacade transactionTypeFacade;


//    @ResponseBody
//    @GetMapping(value = "transactionType")
//    public ResponseEntity<List<TransactionType>> getTransactionTypes() {
//        log.info("Receive GET request /api/transactionType.");
//
//        List<TransactionType> records = transactionTypeFacade.getTransactionTypes();
//        return ResponseEntity.ok(records);
//    }
}
