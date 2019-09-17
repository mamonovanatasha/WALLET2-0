package wallet.web.facade;



import wallet.domain.TransactionType;
import wallet.logic.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeFacade {
    @Autowired
    private TransactionTypeService transactionTypeService;


    public List<TransactionType> getTransactionTypes() {
        return transactionTypeService.findTransactionTypes();
    }
}
