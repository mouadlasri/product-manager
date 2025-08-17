package org.example.productmanager.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { // <Entity, Primary Key>
    // We don't need to write any methods here for basic CRUD.
    // The JpaRepository interface already provides them.
    // Spring will automatically create a class that implements this at runtime.

    // We can add custom methods if we want (that are not basic CRUD)
}
