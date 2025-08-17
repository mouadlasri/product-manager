package org.example.productmanager.product;

import jakarta.persistence.*;
import org.example.productmanager.order.OrderItem;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity // marks this class aqs a JPA entity instead of just a plain java class
@Table(name = "product") // specifies the table name
public class Product {
    @Id // makes this field as a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells the database to auto-increment the ID
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>();


    public Product() {
        // JPA requires a default no-argument constructor
    };

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // getts and setters for all fields (JPA requires these
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
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

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, this.price) == 0 && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                "name=" + name +
                "description=" + description +
                "price=" + price +
                "}";
    }
}
