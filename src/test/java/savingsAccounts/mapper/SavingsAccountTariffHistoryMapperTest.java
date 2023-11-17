package savingsAccounts.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import savingsAccounts.dto.SavingsAccountTariffHistoryDto;
import savingsAccounts.entity.SavingsAccountTariffHistory;
import savingsAccounts.entity.Tariff;
import savingsAccounts.entity.account.SavingsAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class SavingsAccountTariffHistoryMapperTest {
    @Spy
    private SavingsAccountTariffHistoryMapperImpl mapper;

    @Test
    public void testToDto() {
        SavingsAccountTariffHistory entity = new SavingsAccountTariffHistory();
        entity.setId(1L);

        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setId(10L);

        Tariff tariff = new Tariff();
        tariff.setId(100L);

        entity.setSavingsAccount(savingsAccount);
        entity.setTariff(tariff);

        SavingsAccountTariffHistoryDto dto = mapper.toDto(entity);

        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(savingsAccount.getId(), dto.getSavingsAccountId());
        assertEquals(tariff.getId(), dto.getTariffId());
    }

    @Test
    public void testToEntity() {
        SavingsAccountTariffHistoryDto dto = new SavingsAccountTariffHistoryDto();
        dto.setId(1L);
        dto.setSavingsAccountId(10L);
        dto.setTariffId(100L);

        SavingsAccountTariffHistory entity = mapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getSavingsAccountId(), entity.getSavingsAccount().getId());
        assertEquals(dto.getTariffId(), entity.getTariff().getId());
    }

}