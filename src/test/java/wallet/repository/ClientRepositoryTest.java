package wallet.repository;


import wallet.domain.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;


public class ClientRepositoryTest extends JpaDataConfigIT {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TransactionTemplate transactionTemplate;



    @AfterEach
    void tearDown() {
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        transactionTemplate.execute(status -> {
            clientRepository.deleteAll();
            status.flush();

            return status;
        });
    }


    @Test
    void test() {
        Client client = Client.builder()
                .name("test-client")
                .build();

        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        transactionTemplate.execute(status -> {
            clientRepository.save(client);
            status.flush();

            return status;
        });


        assertAll("assert set",
                () -> assertEquals(1, clientRepository.findAll().size())
        );
    }

}