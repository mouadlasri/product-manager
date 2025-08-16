package org.example.productmanager.order.dto;

public class OrderItemResponse {
    private Long id; // if of the order item itself
    private Long productId;
    private int quantity;
    private String productName; // optional
    private double productPrice; // optional (price at the time of order)

    public OrderItemResponse() {}

    public OrderItemResponse(Long id, Long productId, int quantity, String productName, double productPrice) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
