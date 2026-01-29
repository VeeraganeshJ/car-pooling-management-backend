# Car Pooling Management System - Backend

Spring Boot REST API for car pooling management system.

## Features
- User Management APIs
- Ride Management APIs
- Booking Management APIs

## Technologies
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## Setup

```bash
mvn clean install
mvn spring-boot:run
```

Server runs on `http://localhost:8080`

## API Endpoints

### Users
- GET `/api/users`
- GET `/api/users/{id}`
- POST `/api/users`
- PUT `/api/users/{id}`
- DELETE `/api/users/{id}`

### Rides
- GET `/api/rides`
- GET `/api/rides/{id}`
- POST `/api/rides`
- PUT `/api/rides/{id}`
- DELETE `/api/rides/{id}`

### Bookings
- GET `/api/bookings`
- GET `/api/bookings/{id}`
- POST `/api/bookings`
- PUT `/api/bookings/{id}`
- DELETE `/api/bookings/{id}`
