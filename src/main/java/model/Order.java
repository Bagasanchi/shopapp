package model;

public class Order {
    private int id;
    private int productId;
    private String productName;
    private int price;
    private int categoryId;
    private int userId;
    private int quantity;
    private String deliveryName;
    private int deliveryFee;
    private String orderedAt;
    private String userName;
    private String categoryName;

    public Order(int id, int productId, String productName, int price, int categoryId, int userId, int quantity, String deliveryName, int deliveryFee, String orderedAt) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.categoryId = categoryId;
        this.userId = userId;
        this.quantity = quantity;
        this.deliveryName = deliveryName;
        this.deliveryFee = deliveryFee;
        this.orderedAt = orderedAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDeliveryName() { return deliveryName; }
    public void setDeliveryName(String deliveryName) { this.deliveryName = deliveryName; }

    public int getDeliveryFee() { return deliveryFee; }
    public void setDeliveryFee(int deliveryFee) { this.deliveryFee = deliveryFee; }

    public String getOrderedAt() { return orderedAt; }
    public void setOrderedAt(String orderedAt) { this.orderedAt = orderedAt; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public long getAmount() { return (long) price * quantity; }
    public long getTotal() { return getAmount() + deliveryFee; }
}
