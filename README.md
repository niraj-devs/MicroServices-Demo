\# Microservices Demo



<p align="center">

&#x20; <strong>Learning Microservices Through Practical Implementation</strong>

&#x20; <br/>

&#x20; Two independent Spring Boot services communicating through HTTP.

</p>



<p align="center">

&#x20; <img src="https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge\&logo=openjdk" alt="Java"/>

&#x20; <img src="https://img.shields.io/badge/Spring%20Boot-3.5.7-6DB33F?style=for-the-badge\&logo=springboot" alt="Spring Boot"/>

&#x20; <img src="https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge\&logo=apachemaven" alt="Maven"/>

&#x20; <img src="https://img.shields.io/badge/Communication-REST%20API-blue?style=for-the-badge" alt="REST API"/>

</p>



\## About the Project



This project is a hands-on introduction to \*\*Microservices Architecture\*\* using Java and Spring Boot.



Instead of building one large application, we created two independent Spring Boot applications:



\- \*\*Product Service:\*\* Provides product availability information.

\- \*\*Purchase Service:\*\* Communicates with Product Service to process a purchase request.



The services run independently on different ports and communicate using synchronous HTTP requests through Spring's `RestTemplate`.



The goal is simple: understand how independently running services communicate in a real-world backend system.



\## Architecture



```mermaid

flowchart TD

&#x20;   A\[Client / API Tester]

&#x20;   B\[Purchase Service<br/>Port 8080]

&#x20;   C\[RestTemplate]

&#x20;   D\[Product Service<br/>Port 8081]

&#x20;   E\[Product Availability Response]

&#x20;   F\[Purchase Result]



&#x20;   A -->|POST /purchases/1| B

&#x20;   B --> C

&#x20;   C -->|GET /products/1| D

&#x20;   D --> E

&#x20;   E --> B

&#x20;   B --> F

&#x20;   F --> A

```



\### How communication works



1\. A client sends a purchase request to Purchase Service.

2\. Purchase Service receives the product ID.

3\. Its `PurchaseService` uses `RestTemplate` to call Product Service.

4\. Product Service checks whether the requested product is available.

5\. Product Service returns an HTTP response.

6\. Purchase Service uses that response to determine the purchase result.



\*\*Communication type:\*\* Synchronous and blocking HTTP communication.



\## Project Structure



```text

MicroServices-Demo/

│

├── product-service/

│   ├── src/

│   │   └── main/

│   │       ├── java/com/niraj/product/

│   │       │   ├── ProductServiceApplication.java

│   │       │   └── controller/

│   │       │       └── ProductController.java

│   │       └── resources/

│   │           └── application.properties

│   ├── pom.xml

│   └── .gitignore

│

├── purchase-service/

│   ├── src/

│   │   └── main/

│   │       ├── java/com/niraj/purchase/

│   │       │   ├── PurchaseServiceApplication.java

│   │       │   ├── config/

│   │       │   │   └── RestTemplateConfig.java

│   │       │   ├── controller/

│   │       │   │   └── PurchaseController.java

│   │       │   └── service/

│   │       │       └── PurchaseService.java

│   │       └── resources/

│   │           └── application.properties

│   ├── pom.xml

│   └── .gitignore

│

├── .gitignore

└── README.md

```



\## Technology Stack



| Technology | Purpose |

|---|---|

| Java | Programming language |

| Spring Boot | Building independent services |

| Spring Web | Creating REST endpoints |

| RestTemplate | HTTP communication between services |

| Maven | Dependency management and build |

| Git \& GitHub | Version control and collaboration |

| IntelliJ IDEA | Development environment |



\## Services Overview



\### 1. Product Service



\*\*Port:\*\* `8081`



Responsible for checking product availability.



\*\*Endpoint:\*\*



```http

GET /products/{id}

```



Example:



```http

GET http://localhost:8081/products/1

```



Response:



```text

Laptop is Available

```



For other product IDs:



```text

Product out of Stock

```



\### 2. Purchase Service



\*\*Port:\*\* `8080`



Responsible for processing purchase requests by communicating with Product Service.



\*\*Endpoint:\*\*



```http

POST /purchases/{productId}

```



Example:



```http

POST http://localhost:8080/purchases/1

```



Successful response:



```text

Purchase succcessful:Laptop is Available

```



Unavailable product response:



```text

purchase failed:Product out of Stock

```



\## Getting Started



\### Prerequisites



Make sure you have installed:



\- Java JDK 17 or later

\- Maven

\- IntelliJ IDEA or another Java IDE

\- Git



\### Step 1: Clone the repository



```bash

git clone https://github.com/niraj-devs/MicroServices-Demo.git

cd MicroServices-Demo

```



\### Step 2: Start Product Service



Open a terminal:



```bash

cd product-service

mvn spring-boot:run

```



Product Service starts at:



```text

http://localhost:8081

```



Keep this terminal running.



\### Step 3: Start Purchase Service



Open another terminal from the repository root:



```bash

cd purchase-service

mvn spring-boot:run

```



Purchase Service starts at:



```text

http://localhost:8080

```



Both services must be running simultaneously for communication to work.



\## Testing the APIs



You can test the endpoints using Postman or PowerShell.



\*\*Check product availability:\*\*



```powershell

Invoke-RestMethod http://localhost:8081/products/1

```



\*\*Make a successful purchase request:\*\*



```powershell

Invoke-RestMethod -Method POST http://localhost:8080/purchases/1

```



\*\*Try an unavailable product:\*\*



```powershell

Invoke-RestMethod -Method POST http://localhost:8080/purchases/2

```



\## Important Concepts Learned



This implementation helped explore the fundamentals of microservices:



\- \*\*Independent Services:\*\* Each service has its own Spring Boot application and Maven project.

\- \*\*Service-to-Service Communication:\*\* One backend service can communicate with another through HTTP.

\- \*\*REST APIs:\*\* Services expose endpoints to exchange information.

\- \*\*Dependency Injection:\*\* Spring injects `RestTemplate` into the service layer.

\- \*\*Configuration:\*\* Each service uses its own application properties and port.

\- \*\*Synchronous Communication:\*\* The caller waits for the receiving service to respond.

\- \*\*Monorepo:\*\* Multiple independent projects can be maintained in one Git repository.



\## Current Limitations



This is a learning project, not a production-ready microservices platform.



Currently:



\- Product availability is hardcoded.

\- There is no database integration.

\- Service URLs are configured directly in the code.

\- There is no service discovery.

\- There is no API Gateway.

\- There is no centralized logging or distributed tracing.

\- There is no retry or circuit-breaker mechanism.



These are opportunities for future improvements.



\## Future Learning Roadmap



| Stage | Planned Improvement |

|---|---|

| 1 | Explore `WebClient` and Java `HttpClient` |

| 2 | Introduce database integration |

| 3 | Externalize service URLs using configuration |

| 4 | Implement service discovery with Eureka |

| 5 | Introduce Spring Cloud Gateway |

| 6 | Explore fault tolerance with Resilience4j |

| 7 | Containerize services using Docker |

| 8 | Explore asynchronous communication using Kafka |



\## Key Takeaway



A microservice is not simply a separate Spring Boot project.



It is an independently deployable service that communicates with other services through well-defined contracts.



This project demonstrates the first practical step toward understanding distributed backend systems.



\---



<p align="center">

&#x20; <strong>Built while learning Java, Spring Boot and Microservices.</strong>

&#x20; <br/>

&#x20; <sub>Learning by building, testing and improving — one service at a time.</sub>

</p>

