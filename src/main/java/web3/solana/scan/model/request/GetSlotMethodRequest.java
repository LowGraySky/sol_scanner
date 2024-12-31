package web3.solana.scan.model.request;

public class GetSlotMethodRequest extends MethodRequest {

    @Override
    public String getMethod() {
        return "getSlot";
    }
}
