package web3.solana.scan.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class MethodRequestWithParams<T> extends MethodRequest {

    @JsonProperty("params")
    private final T params = getParams();

    protected abstract T getParams();
}
