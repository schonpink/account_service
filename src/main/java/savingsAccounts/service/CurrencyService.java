package savingsAccounts.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import savingsAccounts.entity.account.Currency;
import savingsAccounts.exception.EntityNotFoundException;
import savingsAccounts.repository.CurrencyRepository;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    public Currency getCurrency(String code) {
        return currencyRepository.findById(code)
                .orElseThrow(() -> new EntityNotFoundException("Currency with code " + code + " not found"));
    }
}