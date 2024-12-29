package web3.solana.scan.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web3.solana.scan.model.Transaction;
import web3.solana.scan.repository.TransactionRepository;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Mono<Transaction> insert(Transaction transaction) {
        return transactionRepository.insert(transaction);
    }

    public Flux<Transaction> insert(Iterable<Transaction> iterable) {
        return transactionRepository.saveAll(iterable);
    }

    public Mono<Transaction> save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
