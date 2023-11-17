package savingsAccounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import savingsAccounts.entity.account.AccountStatus;
import savingsAccounts.entity.account.SavingsAccount;

import java.util.List;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
    @Query("SELECT sa FROM SavingsAccount sa WHERE sa.account.id = :accountId AND sa.account.owner.id = :ownerId")
    SavingsAccount findByIdAndOwnerId(Long accountId, Long ownerId);

    List<SavingsAccount> findAllByAccountStatus(AccountStatus accountStatus);

    SavingsAccount findByAccount_Id(Long accountId);

    @Query("SELECT sa.id FROM SavingsAccount sa")
    List<Long> findAllSavingsAccountIds();
}