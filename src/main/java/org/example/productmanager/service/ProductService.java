package org.example.productmanager.service;

import org.example.productmanager.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {
    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public ProductService() {
        products.put(idCounter.getAndIncrement(), new Product(idCounter.get(), "Laptop", "High-performance laptop", 1500.00));
        products.put(idCounter.getAndIncrement(), new Product(idCounter.get(), "Smartphone", "Latest model smartphone", 800.00));

    }

    public Product createProduct(Product product) {
        Long newId = idCounter.incrementAndGet();
        product.setId(newId);
        products.put(newId, product);
        return product;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        if (products.containsKey(id)) {
            updatedProduct.setId(id); // ensure ID is preserved
            products.put(id, updatedProduct);
            return Optional.of(updatedProduct);
        }
        return Optional.empty();
    }

    public boolean deleteProduct(Long id) {
        return products.remove(id) != null;
    }
}
