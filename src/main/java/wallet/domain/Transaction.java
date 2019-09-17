package wallet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "transaction", schema = "wallet_schema")
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "comment")
    private String comment;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Getter(onMethod = @__(@NotNull))
    @Column(name = "transaction_time")
    private LocalDate transactionTime;

    @Getter(onMethod = @__(@NotNull))
    @Column(name = "transaction_amount", nullable = false)
    private BigDecimal transactionAmount;

    @JsonIgnore
    @Getter(onMethod = @__(@NotNull))
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

//    @Getter(onMethod = @__(@NotNull))
//    @Column(name = "user_id", insertable = false, updatable = false)
//    private Long userId;

    @JsonIgnore
    @Getter(onMethod = @__(@NotNull))
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_type_id", referencedColumnName = "transaction_type_id", nullable = false)
    private TransactionType transactionType;

//    @Getter(onMethod = @__(@NotNull))
//    @Column(name = "type-transaction_id", insertable = false, updatable = false)
//    private Long transactionTypeId;


}
