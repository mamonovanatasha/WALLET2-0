package wallet.repository;

import wallet.domain.Transaction;
import wallet.domain.TransactionType;
import wallet.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionRepositoryTest extends JpaDataConfigIT  {
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @AfterEach
    void tearDown() {
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        transactionTemplate.execute(status -> {
            transactionRepository.deleteAll();
            transactionTypeRepository.deleteAll();
            userRepository.deleteAll();
            status.flush();
            return status;
        });
    }


    @Test
    void test() {
        TransactionType transactionType = createTestTransactionType();
        User user = createTestUser();
        Transaction transaction = createTestTransaction();

        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        transactionTemplate.execute(status -> {
            transactionTypeRepository.save(transactionType);
            userRepository.save(user);
            transactionRepository.save(transaction);
            status.flush();

            return status;
        });

        assertAll("assert set",
                () -> assertEquals(1, transactionRepository.findAll().size())
        );
    }

    private Transaction createTestTransaction() {
        User user = createTestUser();
        TransactionType type = createTestTransactionType();
        return Transaction.builder()
                .id(1L)
                .user(user)
                .transactionType(type)
                .transactionAmount(new BigDecimal(1300.00))
                .transactionTime(LocalDate.now())
                .build();

    }

    private User createTestUser() {
        return User.builder()
                .id(1L)
                .name("test_user")
                .build();
    }
    private TransactionType createTestTransactionType() {
        return TransactionType.builder()
                .id(1L)
                .name("test_type")
                .build();
    }

}
