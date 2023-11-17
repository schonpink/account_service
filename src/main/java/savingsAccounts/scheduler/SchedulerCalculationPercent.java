package savingsAccounts.scheduler;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class SchedulerCalculationPercent {
    private final PercentCalculationService percentCalculationService;

    @Scheduled(cron = "${spring.scheduler.calculationPercent.schedule.cron}")
    public void calculateLastUpdatedPercent() {
        percentCalculationService.calculateLastUpdatedPercent();
    }
}