# L2_Calculator

**L2_Calculator** is a showcase project designed as pathfinding calculator between towns from the game **Lineage II**. I chose the clear **Java** language for backend development, in the frontend i decided to use **JavaFX** to create simple desktop GUI. The backend uses graph algorithms (BFS and Dijkstra), and exposes basic REST API that GUI and external tools like **Postman** can communicate with. The Repository also includes a Dockerized **PostgreSQL** database with data representing the teleportation graph between towns. 

### This Respository also contains:
- Unit tests (JUnit)
- Integration tests (with Testcontainers)
- REST API test (Postman) testing

This is my first project, so some parts may not be as good as they could be. However, I aimed to write clean, modular and testable code with a strong focus on the learning process.

---

## How to run L2_Calculator

<img width="986" height="793" alt="image" src="https://github.com/user-attachments/assets/b6ff8bbd-c17e-476f-9dda-1376ecc5ea1f" />

### Requirements

- Java 17+
- Docker (with Docker Compose support)
- Git (Gradle wrapper is included)
- Optional: Postman for API testing

## Step-by-Step Guide
1. **Clone the repository**

Navigate where you want to keep L2_Calculator, open Git bash and write.

   ``` bash
   git clone https://github.com/Thergar/L2_Calculator.git
   ```
   
2. **Check `.env` file**
   
   The .env file is already included in the repository and provides database credentials used by Docker and Spring Boot.

3. **Start PostgreSQL using Docker Compose**
   
   Run this command in your system terminal (PowerShell, cmd, or macOS/Linux terminal) or IntelliJ's built-in terminal, from the project root directory.
   ```
   docker compose up -d
   ```
   PostgreSQL container should start with the correct user/password and mapped volume.

4. **Run the application**
   
   Run this command in your system terminal (PowerShell, cmd, or macOS/Linux terminal) or IntelliJ's built-in terminal, from the project root directory.
   ```
   ./gradlew run
   ```
   This will open a simple JavaFX window with a visual interface of the application, communicating with the backend via HTTP.

   <img width="986" height="793" alt="image" src="https://github.com/user-attachments/assets/17a4fcd5-7db4-4e4e-ba71-8658d859069c" />

---

## About architecture

This project was built to emphasize *modular design* and *clear separation of concerns*:

- **Spring Boot (Backend)** – handles pathfinding logic and exposes REST API
- **JavaFX (GUI)** – a standalone desktop application that communicates via HTTP
- **PostgreSQL database** – stores teleportation graph (towns and connections)
- **Docker + Testcontainers** – simplify setup and ensure consistent test environments

The modular structure makes the project maintainable, testable, and easy to extend by adding new features or scaling it further.

---

## Project Structure

```txt
└── L2_Calculator
    └── src/
        ├── main/
        │   ├── java/
        │   │   ├── Lineage2Calculator
        │   │   │   ├── Algorithms/               → pathfinding logic (BFS, Dijkstra)
        │   │   │   ├── DTO/                      → data transfer objects
        │   │   │   ├── Entities/                 → database entities and repositories
        │   │   │   ├── Errors/                   → exception handling & validation
        │   │   │   ├── Graph/                    → graph model
        │   │   │   ├── REST/                     → Spring Boot REST API controllers
        │   │   │   ├── Services/                 → business logic (graph building, path selection)
        │   │   │   ├── Utils/                    → helpers, dotenv support
        │   │   │   ├── ApplicationFacade.java
        │   │   │   └── Main.java
        │   │   └── Lineage2CalculatorGUI/
        │   │       ├── API/                      → GUI API integration layer 
        │   │       ├── Scenes/                   → JavaFX scenes and UI components
        │   │       └── Utils/                    → input validation, autocomplete
        │   └── resources/
        │       ├── META-INF
        │       ├── application.yml               → Spring Boot config
        │       └── images/                       → Lineage II map and assets
        ├── postman/                              → Postman collection for REST API tests
        └── test/                                 → unit and integration tests
```
---

## Tests

Project includes several layers of testing (unit, integration and API):

### Unit Tests
- Use standard `@Test` (JUnit 5) annotations
- Focused on core algorithms, service logic, and edge cases
- Located in: `src/test/java/Lineage2Calculator/...`

### Integration Tests
- Use custom `@IntegrationTest` annotations
- Boot up a Spring context and a real **PostgreSQL** container via **Testcontainers**
- Used to test repository behavior, service interactions, and REST controllers
- Use `.env` and `application-test.yml` for isolated environments

### API Tests (Postman)
- Manual test collection located in `src/postman/L2Calculator_API.postman_collection.json`
- Covers positive and negative scenarios for all REST endpoints
- Can be imported into Postman and executed

### Notes
- All tests run in JVM Test Engine using Gradle
- Test resources are defined in `src/test/resources`, including SQL dumps and YAML configs
- All test can be run together using:
  ```
  ./gradlew test
  ```

---

## API Overview

The backend exposes a minimal REST API  to fetch towns from database and to calculate paths between them in the Lineaege II world.

**Base URL:** `http://localhost:8080`

### Available Endpoints

| Method | Endpoint       | Description                             |
|--------|----------------|-----------------------------------------|
| GET    | `/towns`       | Returns queries related to available towns   |
| GET    | `/algorithm`  | Returns supported algorithms (BFS, Dijkstra) |
| POST   | `/pathfinding`        | Calculates the path between towns |

### Example POST Request

POST /pathfinding/calculate

Content-Type: application/json

<img width="262" height="193" alt="image" src="https://github.com/user-attachments/assets/1a613a94-29ee-4618-92b2-5d677c45a576" />


API endpoints can be tested using the included Postman collection, simply import file `L2Calculator_API.postman_collection.json` located in package `src/postman/` into Postman and run all requests directly against your local server.
All endpoints may return 400 or 404 for invalid input or when no path can be found. See `ErrorHandling.java` in `Errors/` package.

---

## Security Note

I'm aware that leaving the '.env' file in a public repository is not good a practice. But it was intentional and purely for learning purposes (to better understand how enviroment variables work with Docker and Spring Boot).

---
