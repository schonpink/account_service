package savingsAccounts.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import savingsAccounts.dto.TariffDto;
import savingsAccounts.entity.Tariff;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TariffMapper {
    @Mapping(target = "rates", source = "rate", qualifiedByName = "mapBigDecimalToList")
    Tariff toTariff(TariffDto tariffDto);

    @Mapping(target = "rate", source = "rates", qualifiedByName = "mapListToSingleBigDecimal")
    TariffDto toTariffDto(Tariff tariff);

    @Named("mapListToSingleBigDecimal")
    default BigDecimal mapListToSingleBigDecimal(List<BigDecimal> rates) {
        return rates.get(0);
    }

    @Named("mapBigDecimalToList")
    default List<BigDecimal> mapBigDecimalToList(BigDecimal value) {
        if (value != null) {
            return Collections.singletonList(value);
        }
        return Collections.emptyList();
    }
}