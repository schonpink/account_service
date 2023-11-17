package savingsAccounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savingsAccounts.entity.Tariff;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {
}