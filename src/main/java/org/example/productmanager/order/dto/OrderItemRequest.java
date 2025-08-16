package org.example.productmanager.order.dto;

import org.example.productmanager.order.Order;
import org.example.productmanager.product.Product;

public class OrderItemRequest {
    private int quantity;
    private Product product;
    private Order order;

    public OrderItemRequest() {}

    public OrderItemRequest(int quantity, Product product, Order order) {
        this.quantity = quantity;
        this.product = product;
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
