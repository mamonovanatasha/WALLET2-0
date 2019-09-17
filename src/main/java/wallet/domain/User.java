package wallet.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "users", schema = "wallet_schema")
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private Long id;

    @Getter(onMethod = @__(@NotNull))
    @Column(name = "user_name", nullable = false)
    private String name;
}
