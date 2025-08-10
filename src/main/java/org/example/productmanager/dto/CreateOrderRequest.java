package org.example.productmanager.dto;

import java.util.List;
import java.util.Objects;

public class CreateOrderRequest {
    private String customerName;
    private List<OrderItemRequest> items; // a list of the line items

    public CreateOrderRequest() {}

    public CreateOrderRequest(String customerName, List<OrderItemRequest> items) {
        this.customerName = customerName;
        this.items = items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}
