package wallet.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "transaction_type", schema = "wallet_schema")
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_type_id", nullable = false, unique = true)
    private Long id;

    @Getter(onMethod = @__(@NotNull))
    @Column(name = "transaction_type_name", nullable = false)
    private String name;
}
