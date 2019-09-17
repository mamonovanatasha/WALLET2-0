package wallet.logic.service;

import wallet.domain.TransactionType;
import wallet.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeService {
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    public List<TransactionType> findTransactionTypes() {
        return transactionTypeRepository.findAll();
    }
}
