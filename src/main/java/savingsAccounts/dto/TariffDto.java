package savingsAccounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import savingsAccounts.entity.TariffType;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TariffDto {
    private Long id;
    private TariffType tariffType;
    private BigDecimal rate;
}