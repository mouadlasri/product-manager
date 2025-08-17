package org.example.productmanager.order;

import org.example.productmanager.order.dto.CreateOrderRequest;
import org.example.productmanager.order.dto.OrderItemResponse;
import org.example.productmanager.order.dto.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderService.getAll();

        return orders.stream().map(order -> {
            // 1. get the Set of orderItem from the Order model
            Set<OrderItem> orderItems = order.getOrderItems();

            // 2. convert the Set of OrderItem to a List of OrderItemResponse
            List<OrderItemResponse> orderItemsList = orderItems.stream().map(orderItem -> new OrderItemResponse(
                    orderItem.getId(),
                    orderItem.getOrder().getId(),
                    orderItem.getQuantity(),
                    orderItem.getProduct().getName(),
                    orderItem.getProduct().getPrice()
            )).collect(Collectors.toList());

            // 3. create and return the final OrderResponse DTO with the List of orderItemsList
            return new OrderResponse(
                    order.getId(),
                    order.getCustomerName(),
                    order.getOrderDate(),
                    orderItemsList
            );
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        Order createdOrder = orderService.createOrder(request);

        List<OrderItemResponse> orderItemsList = createdOrder.getOrderItems().stream().map(orderItem -> new OrderItemResponse(
                orderItem.getId(),
                orderItem.getProduct().getId(),
                orderItem.getQuantity(),
                orderItem.getProduct().getName(),
                orderItem.getProduct().getPrice()
        )).collect(Collectors.toList());

        OrderResponse response = new OrderResponse(
                createdOrder.getId(),
                createdOrder.getCustomerName(),
                createdOrder.getOrderDate(),
                orderItemsList
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
