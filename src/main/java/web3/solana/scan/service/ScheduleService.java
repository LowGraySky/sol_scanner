package web3.solana.scan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final SolanaAnalyseService analyseService;

    private void start() {
        analyseService.analyse()
                .subscribeOn(Schedulers.immediate())
                .repeat(1)
                .subscribe();
    }
}
