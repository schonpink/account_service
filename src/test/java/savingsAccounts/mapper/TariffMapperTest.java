package savingsAccounts.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import savingsAccounts.dto.TariffDto;
import savingsAccounts.entity.Tariff;
import savingsAccounts.entity.TariffType;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TariffMapperTest {
    @Spy
    private TariffMapperImpl mapper;
    private TariffDto tariffDto;
    private Tariff tariff;

    @Test
    public void testToTariff() {
        TariffDto tariffDto = new TariffDto();
        tariffDto.setId(1L);
        tariffDto.setTariffType(TariffType.BASE);
        tariffDto.setRate(BigDecimal.valueOf(10.0));

        tariff = mapper.toTariff(tariffDto);

        assertEquals(1L, tariff.getId());
        assertEquals(TariffType.BASE, tariff.getTariffType());
        assertEquals(1, tariff.getRates().size());
        assertEquals(BigDecimal.valueOf(10.0), tariff.getRates().get(0));
    }

    @Test
    public void testToTariffDto() {
        Tariff tariff = new Tariff();
        tariff.setId(2L);
        tariff.setTariffType(TariffType.PROMO);
        tariff.setRates(Collections.singletonList(BigDecimal.valueOf(20.0)));

        tariffDto = mapper.toTariffDto(tariff);

        assertEquals(2L, tariffDto.getId());
        assertEquals(TariffType.PROMO, tariffDto.getTariffType());
        assertEquals(BigDecimal.valueOf(20.0), tariffDto.getRate());
    }
}