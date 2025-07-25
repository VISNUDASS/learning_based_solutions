# Spring Cloud API Gateway

This project implements an API Gateway using Spring Cloud Gateway.

## Features
- Routes requests to Customer Service (`/customer/**`) and Billing Service (`/billing/**`)
- Rate limiting per route
- Caching using Caffeine
- Path rewriting to strip service prefix

## How to Run
1. Make sure you have Java 17+, Maven, and Redis running on `localhost:6379`.
2. Build the project:
   ```
   mvn clean package
   ```
3. Run the API Gateway:
   ```
   mvn spring-boot:run
   ```
4. Customer Service should be available at `http://localhost:8081` and Billing Service at `http://localhost:8082`.

## Configuration
- Edit `application.yml` to change routes, rate limits, or caching.

## Notes
- Rate limiting uses Redis. Ensure Redis is running.
- Caching is enabled via Caffeine.
