package wallet.repository;

import wallet.domain.TransactionType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTypeRepositoryTest extends JpaDataConfigIT  {

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;
    @Autowired
    private TransactionTemplate transactionTemplate;



    @AfterEach
    void tearDown() {
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        transactionTemplate.execute(status -> {
            transactionTypeRepository.deleteAll();
            status.flush();
            return status;
        });
    }


    @Test
    void test() {
        TransactionType transactionType = createTestTransactionType();


        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        transactionTemplate.execute(status -> {
            transactionTypeRepository.save(transactionType);
            status.flush();

            return status;
        });

        assertAll("assert set",
                () -> assertEquals(1, transactionTypeRepository.findAll().size())
        );
    }
    private TransactionType createTestTransactionType() {
        return TransactionType.builder()
                .id(1L)
                .name("test_type")
                .build();
    }

}
