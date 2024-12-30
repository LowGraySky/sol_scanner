package web3.solana.scan.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import web3.solana.scan.model.Transaction;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {

}
