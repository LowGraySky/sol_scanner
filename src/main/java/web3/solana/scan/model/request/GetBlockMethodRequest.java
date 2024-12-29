package web3.solana.scan.model.request;

import java.util.List;

public class GetBlockMethodRequest extends MethodRequestWithParams<List<Object>> {

    private final List<Object> params;

    @Override
    protected String getMethod() {
        return "getBlock";
    }

    @Override
    protected List<Object> getParams() {
        return params;
    }

    public GetBlockMethodRequest(List<Object> objects) {
        this.params = objects;
    }
}
