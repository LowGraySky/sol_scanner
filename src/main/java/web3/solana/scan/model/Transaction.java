package web3.solana.scan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "transaction")
@AllArgsConstructor
public class Transaction {

    @Id
    private String tx;
    private String info;
}
