package web3.solana.scan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import web3.solana.scan.model.request.GetBlockMethodRequest;
import web3.solana.scan.model.request.GetSlotMethodRequest;
import web3.solana.scan.model.response.GetBlockMethodResponse;
import web3.solana.scan.model.response.MethodResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestService {

    private static final String APPLICATION_JSON_HEADER_VALUE = "application/json";
    @Value("${rpc.base.url}")
    private String baseUrl;

    private final WebClient webClient;

    public Mono<MethodResponse<Integer>> getSlot() {
        GetSlotMethodRequest request = new GetSlotMethodRequest();
        return webClient.post()
                .uri(baseUrl)
                .bodyValue(request)
                .header(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_HEADER_VALUE)
                .retrieve()
                .onStatus(HttpStatusCode::isError, errorRequest())
                .toEntity(new ParameterizedTypeReference<MethodResponse<Integer>>() {})
                .map(ResponseEntity::getBody);
    }

    public Mono<MethodResponse<GetBlockMethodResponse>> getBlock(int slotNumber) {
        List<Object> requestObject = new ArrayList<>();
        requestObject.add(slotNumber);

        GetBlockMethodRequest request = new GetBlockMethodRequest(requestObject);
        return webClient.post()
                .uri(baseUrl)
                .bodyValue(request)
                .header(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_HEADER_VALUE)
                .retrieve()
                .onStatus(HttpStatusCode::isError, errorRequest())
                .toEntity(new ParameterizedTypeReference<MethodResponse<GetBlockMethodResponse>>() {})
                .map(ResponseEntity::getBody);
    }

    private Function<ClientResponse, Mono<? extends Throwable>> errorRequest() {
        return response -> {
            log.error("");
            return Mono.just(new RuntimeException(""));
        };
    }
}
