package model;

public class Sales {
    private String name;
    private long quantity;
    private long amount;

    public Sales(String name, long quantity, long amount) {
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public long getQuantity() { return quantity; }
    public void setQuantity(long quantity) { this.quantity = quantity; }

    public long getAmount() { return amount; }
    public void setAmount(long amount) { this.amount = amount; }
}
