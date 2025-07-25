# User and Order Management Microservices

This project contains two Spring Boot microservices:

- **user-service**: Manages users (CRUD), exposes REST APIs, stores data in MySQL.
- **order-service**: Manages orders (CRUD), exposes REST APIs, stores data in MySQL, and communicates with user-service using WebClient (Spring WebFlux).

## How to Run

1. Make sure MySQL is running and create two databases: `userdb` and `orderdb`.
2. Update the `spring.datasource.username` and `spring.datasource.password` in both services' `application.properties` files.
3. Build and run each service using Maven:
   - For user-service:
     ```
     cd user-service
     mvn spring-boot:run
     ```
   - For order-service:
     ```
     cd order-service
     mvn spring-boot:run
     ```

## Endpoints

- User Service: `http://localhost:8081/users`
- Order Service: `http://localhost:8082/orders`

Order Service validates users by calling User Service before creating an order.
