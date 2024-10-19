# ecommerce-project


PROJECTS
Fullstack E-Commerce Platform | Spring Boot, React.js, Redis, Nginx, Linux
• Developed the interactive frontend web with React, Html, CSS, Javascript, Hooks
• Utilized Spring Boot to build a RESTful API service to provide data for the platform
• Implemented a Redis cache to store users' cookie in order to maintain sessions
• Implemented a dashboard to show aggregated metrics by extracting logs from Logstash pipeline
• Deployed the service to a Google Cloud Platform instance with Ubuntu images for hosting

maven
springboot
gradle
dependency injection
postgre-sql/mysql/mongodb/aruora/
cloud aws load balancer ec2 security group network gate   - compute/storage/network
distributed system multi threading lock 
vue react other frontend tool
restful api 
microservice 
apache kafka message queue - event driven


docker kubernetes


authentication


axios

kafka message queue



## Further Development

1. **Configuration & Security Enhancements**
   - Review and update deprecated methods in the Spring Security configuration to ensure compatibility with the latest Spring Security practices.

2. **Implementing HTTPS**
   - Configure the application to enforce HTTPS for all endpoints to enhance security.

3. **Unified Logging Implementation**
   - Integrate a unified logging framework (e.g., SLF4J with Logback or Log4j2) for consistent logging across the application.

4. **Structured API Permission Management**
   - Develop a clearer structure for managing permitted API calls instead of manually adding each endpoint in the security configuration. This could involve using a constants class or configuration file for better readability and maintenance.