package savingsAccounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavingsAccountTariffHistoryDto {
    private Long id;
    private Long savingsAccountId;
    private Long tariffId;
    private LocalDateTime changeDate;
}