# Fullstack E-Commerce Platform

## Overview
A fullstack e-commerce platform built with a focus on performance, scalability, and maintainability. The project uses Spring Boot for backend development, React.js for the frontend, and integrates various technologies for caching, deployment, and security.

## Tech Stack
- **Backend:** Spring Boot, RESTful APIs, Maven, Gradle, Dependency Injection
- **Frontend:** React.js, HTML, CSS, JavaScript, Vue.js (for alternative frontends)
- **Caching:** Redis for session management
- **Database:** PostgreSQL, MySQL, MongoDB, Amazon Aurora (various database options for different use cases)
- **Cloud & DevOps:** Docker, Kubernetes, Google Cloud Platform (GCP), AWS (EC2, Load Balancer, Security Groups, Network Gateway)
- **Message Queue:** Apache Kafka for event-driven architecture
- **Logging & Monitoring:** Unified logging with frameworks like SLF4J, Logback, or Log4j2, Logstash for log aggregation
- **Other Tools:** Nginx, Linux (Ubuntu), Axios for HTTP requests
- **Security:** Authentication, Authorization, Spring Security
- **Distributed Systems:** Multi-threading, concurrency management, locking

## Features
### 1. Frontend Development
- Developed an interactive user interface using React.js, HTML, CSS, and JavaScript.
- Utilized React hooks to manage state and lifecycle events efficiently.

### 2. Backend Development
- Built a robust RESTful API using Spring Boot to handle business logic and data access.
- Implemented dependency injection to manage service components.

### 3. Caching
- Utilized Redis to cache user session data, improving session management and platform responsiveness.

### 4. Log Aggregation Dashboard
- Created a monitoring dashboard that displays aggregated metrics, using data extracted from Logstash pipelines.

### 5. Deployment
- Deployed the platform to a Google Cloud Platform instance using Ubuntu images.
- Configured an Nginx server for reverse proxy and load balancing.

### 6. Microservices & Distributed Architecture
- Designed a microservices architecture for scalability.
- Implemented event-driven communication using Apache Kafka message queues.

### 7. Cloud Infrastructure & DevOps
- Deployed cloud infrastructure on GCP and AWS.
- Configured compute, storage, and network components using EC2, load balancers, security groups, and network gateways.
- Managed containerized services using Docker and Kubernetes.

### 8. Security
- Configured authentication and authorization mechanisms.
- Enhanced API security using Spring Security.

## Further Development
### 1. Configuration & Security Enhancements
- Review and update deprecated methods in the Spring Security configuration to ensure compatibility with the latest practices.

### 2. Implementing HTTPS
- Configure the application to enforce HTTPS for all endpoints for enhanced security.

### 3. Unified Logging Implementation
- Integrate a unified logging framework (e.g., SLF4J with Logback or Log4j2) to achieve consistent logging across the application.

### 4. Structured API Permission Management
- Develop a clearer structure for managing API permissions, such as using a constants class or configuration file for better readability and maintenance.


## Command

### Backend
- ./mvnw spring-boot:run

### Frontend
- npm start

### DB Connection Test
- mysql -h 127.0.0.1 -P 3306 -u myuser2 -p