package org.example.productmanager.repository;

import org.example.productmanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { // <Entity, PrimaryKey>
    // We don't need to write any methods here for basic CRUD.
    // The JpaRepository interface already provides them.
    // Spring will automatically create a class that implements this at runtime.
}
