# Trackerg2

Simple rowing workout tracker made with Spring Boot + Thymeleaf + H2.

## What it does
- shows a workout list
- lets you add a new workout
- stores data in H2 (in-memory)

## Workout fields
- distance (meters)
- split (like `2:05`)
- stroke rate
- date

## Run locally
1. Make sure Java 17 and Maven are installed.
2. In the project folder run:
   ```bash
   mvn spring-boot:run
   ```
3. Open:
   - App: `http://localhost:8080`
   - H2 console: `http://localhost:8080/h2-console`

H2 login values:
- JDBC URL: `jdbc:h2:mem:trackergdb`
- user: `sa`
- password: *(leave blank)*

## Project structure
- `controller` handles routes
- `service` handles basic app logic
- `repository` talks to DB
- `model` is the workout entity
- `templates` are Thymeleaf HTML pages
