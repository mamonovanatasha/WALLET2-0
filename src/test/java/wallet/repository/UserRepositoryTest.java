package wallet.repository;

import wallet.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryTest extends JpaDataConfigIT  {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionTemplate transactionTemplate;



    @AfterEach
    void tearDown() {
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        transactionTemplate.execute(status -> {
            userRepository.deleteAll();
            status.flush();

            return status;
        });
    }


    @Test
    void test() {
        User u = createTestUser();

        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        transactionTemplate.execute(status -> {
            userRepository.save(u);
            status.flush();

            return status;
        });


        assertAll("assert set",
                () -> assertEquals(1, userRepository.findAll().size())
        );
    }

    private User createTestUser() {
        return User.builder()
                .id(1L)
                .name("test_user")
                .build();
    }
}
