package model;

public abstract class Delivery {
    private final String name;
    protected Delivery(String name) { this.name = name; }
    public String getName() { return name; }
    public abstract int calcFee(long amount);
}
