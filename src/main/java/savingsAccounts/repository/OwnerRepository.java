package savingsAccounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savingsAccounts.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}