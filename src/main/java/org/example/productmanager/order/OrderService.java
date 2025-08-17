package org.example.productmanager.order;

import org.example.productmanager.order.dto.CreateOrderRequest;
import org.example.productmanager.order.dto.OrderItemRequest;
import org.example.productmanager.product.Product;
import org.example.productmanager.product.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;

    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order createOrder(CreateOrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setOrderDate(LocalDateTime.now());

        // process the OrderItems from request
        for (OrderItemRequest itemRequest : request.getItems()) {
            // find the product of each OrderItem
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with iD: " + itemRequest.getProductId()));


            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setOrder(order);
            orderItem.setQuantity(itemRequest.getQuantity());


            // add the OrderItem to the Order's  orderItems list
            order.getOrderItems().add(orderItem);
        }

        return orderRepository.save(order);
    }
}
