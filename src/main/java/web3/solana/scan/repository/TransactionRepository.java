package web3.solana.scan.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import web3.solana.scan.model.Transaction;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> { }
