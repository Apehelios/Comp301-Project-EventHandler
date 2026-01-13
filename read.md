<!-- ======================= -->
<!-- Event Handler README -->
<!-- ======================= -->

<style>
body {
  background-color: #ffffff;
  color: #000000;
  font-family: Arial, Helvetica, sans-serif;
  line-height: 1.6;
}

h1, h2, h3, h4 {
  color: #ff7a00;
  font-weight: bold;
}

hr {
  border: none;
  height: 1px;
  background-color: #ff7a00;
  margin: 20px 0;
}

code {
  background-color: #f4f4f4;
  color: #000000;
  padding: 2px 5px;
  border-radius: 4px;
}

pre {
  background-color: #f4f4f4;
  color: #000000;
  padding: 10px;
  border-radius: 6px;
}

ul li {
  margin-bottom: 6px;
}
</style>

# Event Handler – Microservices-Based Event Booking System

---

## Project Overview

Event Handler is a cloud-based event booking and management system developed using a microservices architecture. The project was created for the **COMP301** course and demonstrates modern backend development practices such as service separation, RESTful APIs, Docker containerization, and cloud deployment.

The system allows users to register, browse events, book tickets, and complete payments. Each responsibility is handled by a separate Spring Boot service, enabling scalability, maintainability, and independent deployment.

---

## System Architecture

The application is designed using a **microservices architecture**. Each service runs independently and communicates using HTTP-based REST APIs.

### Services included in the system:

- **User Service**  
  Handles user registration, authentication logic, and wallet balance management.

- **Event Catalog Service**  
  Manages event creation, listing, and event details.

- **Booking Service**  
  Handles ticket reservations and booking logic.

- **Payment Service**  
  Processes payments and deducts user balances.

Each service is implemented as a **Spring Boot** application and deployed separately on the cloud.

---

## Cloud and Deployment

The project is deployed on **Render**, a cloud platform for web services.

### Technologies Used

- Java 17
- Spring Boot 3.x
- PostgreSQL
- Maven
- Docker
- Render Cloud Platform

### Deployment Characteristics

Each microservice:

- Runs as a **separate Render Web Service**
- Uses **environment variables** for configuration
- Connects to a **PostgreSQL database**
- Is packaged and deployed using **Docker**

---

## Configuration

All services use **environment-based configuration** instead of hardcoded values.

### Required Environment Variables

- `SPRING_PROFILES_ACTIVE`
- `DB_HOST`
- `DB_PORT`
- `DB_NAME`
- `DB_USERNAME`
- `DB_PASSWORD`

The database connection is configured dynamically using these variables, making the system suitable for cloud deployment and grading environments.

---

## How the System Works

1. A user registers in the system using the **User Service**.
2. The user adds balance to their account.
3. Events are created and listed using the **Event Catalog Service**.
4. The user selects an event and creates a booking through the **Booking Service**.
5. The **Payment Service** processes the payment and deducts the required amount from the user’s balance.
6. The booking is confirmed if payment is successful.

This flow demonstrates **interaction between multiple microservices**.

---

## Testing and Grading

The system is designed to be tested through **REST API calls** using tools such as **Postman** or **curl**.

- Each service exposes HTTP endpoints independently.
- No frontend UI is required for testing.
- No local database setup is required for grading.

All services are deployed and configured on the cloud using environment variables.

---

## Docker Support

Each microservice contains its **own Dockerfile**.

Docker is used to:

- Build the application consistently
- Package dependencies
- Ensure the same runtime behavior across environments

This allows the instructor to redeploy or test the system in a controlled environment.

---

## Team Members

- **Hakan Demircan**  
  Booking Service, Payment Service, Docker configuration, Cloud deployment, System integration, System documentation SDD

- **Onurcan Ceyhan**  
  User Service

- **Muhammet Talha Çatal**  
  Event Catalog Service

---

## Course Information

- **Course:** COMP301 – Software Architecture and Tools
- **Instructor:** Engin Kandıran
- **Institution:** Yeditepe University

---

## Project Goals Achieved

- Implementation of microservices architecture
- RESTful API design
- Cloud-based deployment
- Docker containerization
- PostgreSQL database integration
- Environment-based configuration

---

## Useful Links

---

### 1. GitHub Repository

https://github.com/Apehelios/Comp301-Project-EventHandler.git  
**Branch:** `hakan-dev`

---

### 2. Deployed Microservices (Render)

**User Service**  
https://springboot-render-app-user.onrender.com  
Service ID: `srv-d5imfe24d50c73d1q2o0`

**Booking Service**  
https://springboot-render-app-booking.onrender.com  
Service ID: `srv-d5imjg63jp1c73f175gg`

**Payment Service**  
https://springboot-render-app-payment.onrender.com  
Service ID: `srv-d5imgs3e5dus73e80cv0`

**Event Catalog Service**  
https://springboot-render-app-event.onrender.com  
Service ID: `srv-d5imfe24d50c73d1q2o0`

**Note:**  
All services expose REST APIs under the `/api/*` path.  
Accessing the root URL (`/`) returns **404 by design**.

---

### 3. API Testing (Postman)

All endpoints are designed to be tested using **Postman**.

**Example Endpoints:**

- `POST /api/users/register`
- `POST /api/users/login`
- `POST /api/bookings`
- `POST /api/payments`
- `GET  /api/events`

JSON is used for both request and response bodies.

---

### 4. Database (PostgreSQL on Render)

**Database Provider:** Render Cloud PostgreSQL


