package savingsAccounts.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import savingsAccounts.dto.TariffDto;
import savingsAccounts.entity.Tariff;
import savingsAccounts.exception.TariffNotFoundException;
import savingsAccounts.mapper.TariffMapper;
import savingsAccounts.repository.TariffRepository;
import savingsAccounts.validator.TariffValidator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TariffService {
    private final TariffRepository tariffRepository;
    private final TariffValidator tariffValidator;
    private final TariffMapper tariffMapper;

    @Transactional
    public TariffDto createTariff(TariffDto tariffDto) {
        tariffValidator.validateTariff(tariffDto);
        log.info("Creating new tariff: {}", tariffDto);
        Tariff tariff = tariffMapper.toTariff(tariffDto);

        return tariffMapper.toTariffDto(tariffRepository.save(tariff));
    }

    @Transactional(readOnly = true)
    public TariffDto getTariffById(Long id) {
        log.info("Getting tariff by ID: {}", id);
        Optional<Tariff> tariff = tariffRepository.findById(id);
        return tariff.map(tariffMapper::toTariffDto)
                .orElseThrow(() -> new TariffNotFoundException("Tariff with id " + id + " not found"));
    }

    @Transactional(readOnly = true)
    public List<TariffDto> getAllTariffs() {
        log.info("Getting all tariffs");
        List<Tariff> tariffs = tariffRepository.findAll();
        return tariffs.stream()
                .map(tariffMapper::toTariffDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public TariffDto updateTariff(Long id, TariffDto tariffDto) {
        log.info("Updating tariff with ID {}: {}", id, tariffDto);
        Tariff existingTariff = tariffRepository.findById(id)
                .orElseThrow(() -> new TariffNotFoundException("Tariff not found"));

        existingTariff.setTariffType(tariffDto.getTariffType());

        List<BigDecimal> newRates = new ArrayList<>();
        newRates.add(tariffDto.getRate());
        existingTariff.setRates(newRates);

        Tariff savedTariff = tariffRepository.save(existingTariff);

        return tariffMapper.toTariffDto(savedTariff);
    }


    public void updateTariffRate(Long tariffId, BigDecimal newRate) {
        log.info("Updating rate with tariff ID {}: {}", tariffId, newRate);
        Tariff existingTariff = tariffRepository.findById(tariffId)
                .orElseThrow(() -> new TariffNotFoundException("Tariff not found"));

        existingTariff.getRates().add(newRate);

        tariffRepository.save(existingTariff);
    }

    public void deleteTariff(Long id) {
        log.info("Deleting tariff with ID: {}", id);
        Tariff tariff = tariffRepository.findById(id)
                .orElseThrow(() -> new TariffNotFoundException("Tariff with ID " + id + " not found"));

        tariffRepository.delete(tariff);
    }
}