package wallet.web.dto.converter;

import wallet.domain.Transaction;
import wallet.domain.TransactionType;
import wallet.domain.User;
import wallet.repository.TransactionTypeRepository;
import wallet.web.dto.TransactionDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionDtoConverterTest {

    @InjectMocks
    private TransactionDtoConverter converter;

    @Mock
    private TransactionTypeRepository repository;


    @Test
    void test_example() {
        Transaction tr = createTestTransaction();

        when(repository.findById(any())).thenReturn(Optional.of(createTestTransactionType()));


        TransactionDto transactionDto = converter.convertToDto(tr);


        assertEquals("test_type", transactionDto.getTransactionType());
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

    private TransactionType createTestTransactionType() {
        return TransactionType.builder()
                    .id(1L)
                    .name("test_type")
                    .build();
    }

    private User createTestUser() {
        return User.builder()
                    .id(1L)
                    .name("test_user")
                    .build();
    }

}