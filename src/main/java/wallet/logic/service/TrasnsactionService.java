package wallet.logic.service;

import wallet.domain.Transaction;
import wallet.repository.TransactionRepository;
import wallet.web.dto.TransactionDto;
import wallet.web.dto.converter.TransactionDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrasnsactionService {

    @Autowired
    private TransactionDtoConverter converter;
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> finTransactions() {
        return transactionRepository.findAll();
    }

    public List<TransactionDto> findTransactionsByUserId(@NotNull Long userId) {
        List<TransactionDto> resultList = new ArrayList<>();

        List<Transaction> transactionList = transactionRepository.findByUserId(userId);

        for ( Transaction transaction : transactionList ) {
            resultList.add(converter.convertToDto(transaction));
        }

        return resultList;
    }
}
