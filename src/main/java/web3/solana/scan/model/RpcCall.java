package web3.solana.scan.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface RpcCall {

    @JsonProperty("jsonrpc")
    String jsonRpc = "2.0";
    @JsonProperty("id")
    int id = 1;
}
