package model;

public class ExpressDelivery extends Delivery {
    public ExpressDelivery() { super("Express"); }
    @Override public int calcFee(long amount) { return 10000; }
}
