package model;

public class StandardDelivery extends Delivery {
    public StandardDelivery() { super("Standard"); }
    @Override public int calcFee(long amount) { return amount >= 50000 ? 0 : 5000; }
}
