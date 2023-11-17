package savingsAccounts.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import savingsAccounts.dto.SavingsAccountDto;
import savingsAccounts.entity.account.SavingsAccount;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface SavingsAccountMapper {
    @Mapping(source = "accountId", target = "account.id")
    SavingsAccount toEntity(SavingsAccountDto savingsAccountDto);

    @Mapping(source = "account.id", target = "accountId")
    SavingsAccountDto toDto(SavingsAccount savingsAccount);
}