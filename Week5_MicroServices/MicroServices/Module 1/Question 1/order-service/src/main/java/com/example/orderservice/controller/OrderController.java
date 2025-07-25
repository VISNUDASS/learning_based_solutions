package com.example.orderservice.controller;

import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Value("${user.service.url}")
    private String userServiceUrl;

    private final WebClient webClient = WebClient.create();

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Mono<Order> createOrder(@RequestBody Order order) {
        // Validate user exists in User Service
        return webClient.get()
                .uri(userServiceUrl + "/users/" + order.getUserId())
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(user -> Mono.just(orderRepository.save(order)))
                .onErrorResume(e -> Mono.error(new RuntimeException("User not found")));
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        return orderRepository.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }
}
