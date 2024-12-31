package web3.solana.scan.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web3.solana.scan.model.Transaction;
import web3.solana.scan.model.response.GetBlockMethodResponse;
import web3.solana.scan.model.response.MethodResponse;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SolanaAnalyseService {

  private final ObjectMapper objectMapper;
  private final RequestService requestService;
  private final TransactionService transactionService;

  public Mono<Void> analyse() {
    return requestService.getSlot()
            .flatMap(response -> requestService.getBlock(response.getResult()))
            .map(MethodResponse::getResult)
            .map(GetBlockMethodResponse::getTransactionModel)
            .flux()
            .flatMap(this::saveToMongo)
            .then()
            .doOnError(error -> log.error("ERROR: when analyse, error: {}", error.getMessage()));
  }

  private Flux<Transaction> saveToMongo(List<GetBlockMethodResponse.TransactionModel> transactionModels) {
    List<Transaction> transactions = transactionModels
            .stream()
            .map(this::toTransaction)
            .toList();
    return transactionService.insert(transactions);
  }

  private Transaction toTransaction(GetBlockMethodResponse.TransactionModel transactionModel) {
    return new Transaction(
            transactionModel.getSignatures().getFirst(),
            objectMapper.convertValue(transactionModel, String.class)
    );
  }
}
