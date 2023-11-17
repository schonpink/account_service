package savingsAccounts.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import savingsAccounts.entity.account.AccountStatus;
import savingsAccounts.entity.account.AccountType;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SavingsAccountDto {
    private Long id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long accountId;
    @NotNull(message = "Account type is required")
    private AccountType accountType;
    private AccountStatus accountStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime closedAt;
    private LocalDateTime lastUpdateCalculationAt;
}