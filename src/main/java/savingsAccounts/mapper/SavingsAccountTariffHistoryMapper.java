package savingsAccounts.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import savingsAccounts.dto.SavingsAccountTariffHistoryDto;
import savingsAccounts.entity.SavingsAccountTariffHistory;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface SavingsAccountTariffHistoryMapper {
    @Mapping(source = "savingsAccount.id", target = "savingsAccountId")
    @Mapping(source = "tariff.id", target = "tariffId")
    SavingsAccountTariffHistoryDto toDto(SavingsAccountTariffHistory entity);

    @Mapping(source = "savingsAccountId", target = "savingsAccount.id")
    @Mapping(source = "tariffId", target = "tariff.id")
    SavingsAccountTariffHistory toEntity(SavingsAccountTariffHistoryDto dto);
}