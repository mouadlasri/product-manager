package org.example.productmanager.dto;

import java.util.Objects;

public class CreateProductRequest {
    private String name;
    private String description;
    private double price;

    public CreateProductRequest() {};

    public CreateProductRequest(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateProductRequest that = (CreateProductRequest) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }

    @Override
    public String toString() {
        return "CreateProductRequest{" +
                "name=" + name +
                "description=" + description +
                "price=" + price +
                "}";
    }
}
