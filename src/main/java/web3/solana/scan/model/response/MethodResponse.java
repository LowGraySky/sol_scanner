package web3.solana.scan.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import web3.solana.scan.model.RpcCall;

@Getter
public class MethodResponse<T> implements RpcCall {

    @JsonProperty("result")
    private T result;
}
