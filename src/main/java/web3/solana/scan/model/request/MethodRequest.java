package web3.solana.scan.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import web3.solana.scan.model.RpcCall;

public abstract class MethodRequest implements RpcCall {

    @JsonProperty("method")
    private final String method = getMethod();

    public abstract String getMethod();
}
