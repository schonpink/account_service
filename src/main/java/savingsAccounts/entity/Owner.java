package savingsAccounts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import savingsAccounts.entity.account.Account;
import savingsAccounts.entity.account.OwnerType;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    @Enumerated
    private OwnerType type;

    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    @OneToMany(mappedBy = "owner")
    private List<Account> accounts;

    @ManyToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;
}