package wallet.repository;

import wallet.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "SELECT * FROM wallet_schema.Transaction e WHERE e.user_id = ?", nativeQuery = true)
    List<Transaction> findByUserId(Long userId);
}
