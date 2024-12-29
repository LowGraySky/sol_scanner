package web3.solana.scan.model.request;

public class GetSlotMethodRequest extends MethodRequest {

    @Override
    protected String getMethod() {
        return "getSlot";
    }
}
