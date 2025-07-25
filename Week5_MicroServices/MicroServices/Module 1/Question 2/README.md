# Inventory Management System with Service Discovery

This project demonstrates a microservices architecture using Spring Boot, Spring Cloud Netflix Eureka for service discovery, and Spring Cloud Config Server for centralized configuration.

## Services
- **config-server**: Centralized configuration
- **eureka-server**: Service discovery
- **product-service**: Manages products and stock
- **inventory-service**: Tracks stock levels

## How to Run
Each service is a Spring Boot application. Build and run them in the following order:
1. config-server
2. eureka-server
3. product-service
4. inventory-service

## Prerequisites
- Java 17+
- Maven

## Endpoints
- Eureka dashboard: `http://localhost:8761`
- Product Service: `http://localhost:8081`
- Inventory Service: `http://localhost:8082`
