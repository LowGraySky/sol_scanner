package web3.solana.scan.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {

  private final SolanaAnalyseService analyseService;

  @PostConstruct
  private void start() {
    Flux.interval(Duration.ofSeconds(30), Duration.ofMinutes(2))
            .doOnNext(task -> log.info("TASK: Start execute analyse task"))
            .flatMap(x -> analyseService.analyse())
            .subscribeOn(Schedulers.immediate())
            .subscribe();
  }
}
