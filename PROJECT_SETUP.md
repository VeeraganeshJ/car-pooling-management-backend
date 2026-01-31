# Car-Pooling Management System

A full-stack web application for managing car-pooling rides and bookings built with Spring Boot, React, and H2 Database.

## Tech Stack

### Backend
- **Spring Boot 4.0.2** - Java framework for building REST APIs
- **Spring Data JPA** - ORM for database operations
- **H2 Database** - In-memory database
- **Lombok** - Reduce boilerplate code
- **Maven** - Project build and dependency management
- **Java 17** - Programming language

### Frontend
- **React 19.2.3** - JavaScript UI library
- **Axios** - HTTP client for API calls
- **CSS3** - Styling

## Project Structure

```
carpooling-management/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── entity/
│   │   │   │   ├── User.java
│   │   │   │   ├── Ride.java
│   │   │   │   └── Booking.java
│   │   │   ├── repository/
│   │   │   │   ├── UserRepository.java
│   │   │   │   ├── RideRepository.java
│   │   │   │   └── BookingRepository.java
│   │   │   ├── service/
│   │   │   │   ├── UserService.java
│   │   │   │   ├── RideService.java
│   │   │   │   └── BookingService.java
│   │   │   ├── controller/
│   │   │   │   ├── UserController.java
│   │   │   │   ├── RideController.java
│   │   │   │   └── BookingController.java
│   │   │   └── DemoApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── UserManagement.js
│   │   │   ├── RideManagement.js
│   │   │   └── BookingManagement.js
│   │   ├── api/
│   │   │   └── api.js
│   │   ├── styles/
│   │   │   ├── UserManagement.css
│   │   │   ├── RideManagement.css
│   │   │   └── BookingManagement.css
│   │   ├── App.js
│   │   ├── App.css
│   │   └── index.js
│   └── package.json
├── pom.xml
└── README.md
```

## Features

### User Management
- Create, read, update, and delete user profiles
- Store user information (name, email, phone, address, rating)
- Search users by email or phone

### Ride Management
- Create and manage rides (driver-initiated)
- Filter rides by status (SCHEDULED, IN_PROGRESS, COMPLETED, CANCELLED)
- Search rides by location
- Update ride details and status
- Display available seats and pricing

### Booking Management
- Book seats on available rides
- Confirm or cancel bookings
- Track booking status (PENDING, CONFIRMED, CANCELLED, COMPLETED)
- Automatic seat availability management

## API Endpoints

### Users API
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `GET /api/users/email/{email}` - Get user by email
- `POST /api/users` - Create new user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

### Rides API
- `GET /api/rides` - Get all rides
- `GET /api/rides/{id}` - Get ride by ID
- `GET /api/rides/status/{status}` - Get rides by status
- `GET /api/rides/search?startingLocation=X&destination=Y` - Search rides
- `GET /api/rides/driver/{driverId}` - Get rides by driver
- `POST /api/rides` - Create new ride
- `PUT /api/rides/{id}` - Update ride
- `PATCH /api/rides/{id}/status?status=STATUS` - Update ride status
- `DELETE /api/rides/{id}` - Delete ride

### Bookings API
- `GET /api/bookings` - Get all bookings
- `GET /api/bookings/{id}` - Get booking by ID
- `GET /api/bookings/passenger/{passengerId}` - Get bookings by passenger
- `GET /api/bookings/ride/{rideId}` - Get bookings by ride
- `GET /api/bookings/status/{status}` - Get bookings by status
- `POST /api/bookings` - Create new booking
- `PUT /api/bookings/{id}` - Update booking
- `PATCH /api/bookings/{id}/confirm` - Confirm booking
- `PATCH /api/bookings/{id}/cancel` - Cancel booking
- `DELETE /api/bookings/{id}` - Delete booking

## Prerequisites

- Java 17 or higher
- Node.js 14 or higher
- Maven 3.6 or higher
- npm or yarn

## Setup Instructions

### Backend Setup

1. **Navigate to the project root directory:**
   ```bash
   cd d:\Academic Collections\DevOps\carpooling-management
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the Spring Boot application:**
   ```bash
   mvn spring-boot:run
   ```

   The backend will start on `http://localhost:8080`

4. **Access H2 Console (optional):**
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: (leave empty)

### Frontend Setup

1. **Navigate to the frontend directory:**
   ```bash
   cd frontend
   ```

2. **Install dependencies:**
   ```bash
   npm install
   ```

3. **Start the development server:**
   ```bash
   npm start
   ```

   The frontend will start on `http://localhost:3000`

## Database Configuration

The application uses an in-memory H2 database configured in `src/main/resources/application.properties`:

- **Driver:** `org.h2.Driver`
- **URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** (empty)
- **DDL Auto:** `create-drop` (creates tables on startup, drops on shutdown)

## Testing the Application

1. **Start the backend server** (on port 8080)
2. **Start the frontend server** (on port 3000)
3. **Open browser** to `http://localhost:3000`

### Sample Test Data

**Create a User:**
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "phone": "555-0123",
  "address": "123 Main St, City"
}
```

**Create a Ride:**
```json
{
  "startingLocation": "Downtown",
  "destination": "Airport",
  "departureTime": "2026-01-25T10:00:00",
  "availableSeats": 4,
  "pricePerSeat": 25.00,
  "description": "Comfortable ride to airport",
  "driver": {"id": 1}
}
```

**Create a Booking:**
```json
{
  "ride": {"id": 1},
  "passenger": {"id": 2},
  "seatsBooked": 2
}
```

## Features Implemented

✅ Entity Models with JPA Annotations  
✅ Spring Data JPA Repositories  
✅ Service Layer with Business Logic  
✅ RESTful API Controllers with CORS  
✅ H2 Database Integration  
✅ React Frontend with Component-Based Architecture  
✅ API Integration with Axios  
✅ CRUD Operations for All Entities  
✅ Form Validation and Error Handling  
✅ Responsive UI Design  
✅ Tab Navigation  
✅ Data Tables with Actions  

## Common Issues & Solutions

### Port Already in Use
- Backend: `mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"`
- Frontend: `PORT=3001 npm start`

### CORS Error
- The application is configured to accept requests from `http://localhost:3000`
- Update `@CrossOrigin` annotation in controllers if needed

### H2 Console Not Loading
- Ensure `spring.h2.console.enabled=true` in application.properties
- Access it at `http://localhost:8080/h2-console`

## Future Enhancements

- User authentication and authorization
- Payment integration
- Email notifications
- Real-time chat between driver and passengers
- Review and rating system
- Map integration for location visualization
- Advanced filtering and search
- Mobile app version

## License

This project is part of an academic DevOps collection.

---

**Created:** January 2026  
**Project Type:** Full-Stack Web Application  
**Status:** Development Complete
