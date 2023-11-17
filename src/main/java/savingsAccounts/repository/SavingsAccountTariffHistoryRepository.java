package savingsAccounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savingsAccounts.entity.SavingsAccountTariffHistory;
import savingsAccounts.entity.account.SavingsAccount;

@Repository
public interface SavingsAccountTariffHistoryRepository extends JpaRepository<SavingsAccountTariffHistory, Long> {
    SavingsAccountTariffHistory findTopBySavingsAccountOrderByChangeDateDesc(SavingsAccount savingsAccount);
}