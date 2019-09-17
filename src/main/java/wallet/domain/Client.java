package wallet.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "client", schema = "wallet_schema")
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Getter(onMethod = @__(@NotNull))
    @Column(name = "name", nullable = false)
    private String name;

}
