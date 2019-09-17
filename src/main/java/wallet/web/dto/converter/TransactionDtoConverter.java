package wallet.web.dto.converter;

import wallet.domain.Transaction;
import wallet.domain.TransactionType;
import wallet.repository.TransactionTypeRepository;
import wallet.repository.UserRepository;
import wallet.web.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class TransactionDtoConverter {
    private static final String DATE_FORMAT = "MM.dd.yyyy";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;


    @NotNull
    public TransactionDto convertToDto(@NotNull Transaction transaction) {
        String transactionDateStringFormat = convertLocalDateToString(transaction.getTransactionTime());

        TransactionType transactionType = transactionTypeRepository.findById(transaction.getId())
                .orElseThrow(() -> new RuntimeException("Error. Contribution not found."));


        return TransactionDto.builder()
                .amount(transaction.getTransactionAmount())
                .comment(transaction.getComment())
                .transactionDate(transactionDateStringFormat)
                .transactionType(transactionType.getName())
                .build();
    }
    private String convertLocalDateToString(LocalDate transactionDate) {
        return transactionDate != null ? transactionDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT)) : null;
    }
}
