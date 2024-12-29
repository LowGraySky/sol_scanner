package web3.solana.scan.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class GetBlockMethodResponse {

    @JsonProperty("transactions")
    private List<TransactionModel> transactionModel;

    @Getter
    public static class TransactionModel {

        @JsonProperty("meta")
        private Meta meta;
        @JsonProperty("message")
        private Message message;
        @JsonProperty("signatures")
        private List<String> signatures;
    }

    @Getter
    public static class Meta {

        @JsonProperty("err")
        private String err;
        @JsonProperty("fee")
        private int fee;
        @JsonProperty("postTokenBalances")
        private List<TokenBalance> postTokenBalances;
        @JsonProperty("preTokenBalances")
        private List<TokenBalance> preTokenBalances;
    }

    @Getter
    public static class TokenBalance {

        @JsonProperty("mint")
        private String mint;
        @JsonProperty("uiTokenAmount")
        private UiTokenAmount uiTokenAmount;
    }

    @Getter
    public static class UiTokenAmount {

        @JsonProperty("uiAmount")
        private BigDecimal uiAmount;
    }


    @Getter
    public static class Message {

        @JsonProperty("accountKeys")
        private List<String> accountKeys;
    }
}
