# L2_Calculator

**L2_Calculator** is a showcase project designed as pathfinding calculator between towns from the game **Lineage II**. I chose the clear **Java** language for l2calculator development, in the frontend i decided to use **JavaFX** to create simple desktop GUI. The l2calculator uses graph algorithms (BFS and Dijkstra), and exposes basic l2calculator.rest l2calculator.api that GUI and external tools like **Postman** can communicate with. The Repository also includes a Dockerized **PostgreSQL** database with data representing the teleportation graph between towns. 

![Demo](https://github.com/user-attachments/assets/b16b6960-3cf8-4f1e-bdc7-979cc1f02c2d)

### This Respository also contains:
- Unit tests (JUnit)
- Integration tests (with Testcontainers)
- l2calculator.rest l2calculator.api test (Postman) testing

This is my first project, so some parts may not be as good as they could be. However, I aimed to write clean, modular and testable code with a strong focus on the learning process.

---

## How to run L2_Calculator

### Requirements

- Java 17+
- Docker + WSL (with Docker Compose support)
- Git (Gradle wrapper is included)
- Optional: Postman for l2calculator.api testing

## Step-by-Step Guide
1. **Clone the repository**

Navigate where you want to keep L2_Calculator, open Git bash and write.

   ``` bash
   git clone https://github.com/Thergar/L2_Calculator.git
   ```
   
2. **Check `.env` file**
   
   The .env file is already included in the repository and provides database credentials used by Docker and Spring Boot.

3. **Start the services with Docker Compose. Before moving on, make sure that the Docker Compose stack is healthy**
   
   Run this command in your system terminal (PowerShell, cmd, or macOS/Linux terminal) or IntelliJ's built-in terminal, from the project root directory.
   ```
   docker compose up -d --wait
   docker compose ps
   ```
   PostgreSQL container should start with the correct user/password and mapped volume.
   
4. **Run the GUI of the application**

   The GUI module does not yet implement lazy-loading/retry for the **cities list** (Lazy-loading with retry/backoff will be added in a future iteration). It currently assumes the
   backend (Spring Boot) and database are already up. If the services aren't up, the GUI will throw a fatal error and application will not start.
   
   Run this command in your system terminal (PowerShell, cmd, Git Bash or macOS/Linux terminal) or IntelliJ's built-in terminal, from the project root directory.
   ```
   .\gradlew run    # Windows
   ./gradlew run    # macOS/Linux
   ```
   This will open a simple JavaFX window with a visual interface of the application, communicating with the l2calculator via HTTP.

   <img width="986" height="793" alt="image" src="https://github.com/user-attachments/assets/17a4fcd5-7db4-4e4e-ba71-8658d859069c" />

---

## About architecture

This project was built to emphasize *modular design* and *clear separation of concerns*:

- **Spring Boot (Backend)** – handles pathfinding logic and exposes l2calculator.rest l2calculator.api
- **JavaFX (GUI)** – a standalone desktop application that communicates via HTTP
- **PostgreSQL database** – stores teleportation graph (towns and connections)
- **Docker + Testcontainers** – simplify setup and ensure consistent test environments

The modular structure makes the project maintainable, testable, and easy to extend by adding new features or scaling it further.

---

## Project Structure

This repository is organized as a multi-module Gradle project:

- **backend** — Spring Boot REST API, contains business logic, database entities, repositories, and REST controllers.
- **dto** — Shared Data Transfer Objects used for communication between backend and GUI.
- **gui** — JavaFX desktop client, provides a graphical interface and integrates with the backend API.
- **postman** — Postman collection with positive and negative tests for REST API endpoints.

```text
└── L2_Calculator
    ├── backend/                           → Spring Boot backend
    │   └── src/
    │       ├── main/
    │       │   ├── java/
    │       │   │   └── l2calculator/
    │       │   │       ├── algorithms/               → pathfinding logic (BFS, Dijkstra)
    │       │   │       ├── entities/                 → database entities and repositories
    │       │   │       ├── errors/                   → exception handling & validation
    │       │   │       ├── graph/                    → graph model
    │       │   │       ├── rest/                     → Spring Boot REST controllers
    │       │   │       ├── services/                 → business logic (graph building, path selection)
    │       │   │       └── utils/                    → helpers, dotenv support
    │       │   └── resources/
    │       │       ├── application.yml               → Spring Boot config
    │       │       └── images/                       → Lineage II map and assets
    │       └── test/                                 → unit and integration tests
    │
    ├── dto/                               → Shared Data Transfer Objects
    │   └── src/
    │       └── main/java/l2calculator/
    │           └── dto/                   → data transfer objects
    │
    ├── gui/                               → JavaFX client
    │   └── src/
    │       ├── main/
    │       │   ├── java/
    │       │   │   └── l2calculator/
    │       │   │       ├── api/                      → GUI API integration layer
    │       │   │       ├── scenes/                   → JavaFX scenes and UI components
    │       │   │       └── utils/                    → input validation, autocomplete
    │       │   └── resources/images/                 → Lineage II map and assets
    │       └── test/                                 → GUI tests
    │
    ├── postman/                          → Postman collection for REST API tests
    │
    ├── docker-compose.yml                → Docker Compose setup
    └── settings.gradle.kts               → Gradle settings
```
---

## Tests

Project includes several layers of testing (unit, integration and l2calculator.api):

### Unit Tests
- Use standard `@Test` (JUnit 5) annotations
- Focused on core algorithms, service logic, and edge cases
- Located in: `src/test/java/Lineage2Calculator/...`

### Integration Tests
- Use custom `@IntegrationTest` annotations
- Boot up a Spring context and a real **PostgreSQL** container via **Testcontainers**
- Used to test repository behavior, service interactions, and l2calculator.rest controllers
- Use `.env` and `application-test.yml` for isolated environments

### l2calculator.api Tests (Postman)
- Manual test collection located in `src/postman/L2Calculator_API.postman_collection.json`
- Covers positive and negative scenarios for all l2calculator.rest endpoints
- Can be imported into Postman and executed

### Notes
- All tests run in JVM Test Engine using Gradle
- Test resources are defined in `src/test/resources`, including SQL dumps and YAML configs
- All test can be run together using:
  ```
  ./gradlew test
  ```

---

## l2calculator.api Overview

The l2calculator exposes a minimal l2calculator.rest l2calculator.api  to fetch towns from database and to calculate paths between them in the Lineaege II world.

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


l2calculator.api endpoints can be tested using the included Postman collection, simply import file `L2Calculator_API.postman_collection.json` located in package `src/postman/` into Postman and run all requests directly against your local server.
All endpoints may return 400 or 404 for invalid input or when no path can be found. See `ErrorHandling.java` in `l2calculator.errors/` package.

---

## Security Note

I'm aware that leaving the '.env' file in a public repository is not good a practice. But it was intentional and purely for learning purposes (to better understand how enviroment variables work with Docker and Spring Boot).

---
