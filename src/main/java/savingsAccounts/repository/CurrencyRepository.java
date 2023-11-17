package savingsAccounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savingsAccounts.entity.account.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {
}