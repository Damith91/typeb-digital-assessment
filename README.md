# Hello World Application

## Overview

This is a Spring Boot REST API application that checks the first character of a given name.

- If the first character is between **A–M (a–m)**, the API returns a success response with HTTP 200.
- If the first character is between **N–Z (n–z)**, the API returns an error response with HTTP 400.

## API Endpoint

**GET** `/api/v1/hello-world`

### Request Parameter

| Parameter | Description | Required |
|---|---|---|
| name | Name to validate | Yes |

### Example Requests

**Successful request:**

```http
GET /api/v1/hello-world?name=alice
```

Response (200 OK):

```json
{
  "message": "Hello alice"
}
```

**Invalid request:**

```http
GET /api/v1/hello-world?name=Nancy
```

Response (400 Bad Request):

```json
{
  "error": "Invalid Input"
}
```

## How to Run the Application

### Prerequisites

- Java JDK (version configured in the project)
- Maven
- IDE such as IntelliJ IDEA or Eclipse (optional)

### Steps

1. Clone or download the project.
2. Navigate to the project root directory.
3. Build the application:

```bash
mvn clean install
```

4. Run the application:

```bash
mvn spring-boot:run
```

5. The application will start on the default port `8080`.

Access the API:

```text
http://localhost:8080/api/v1/hello-world?name=alice
```

## How to Run the Tests

The project uses JUnit 5, Mockito, and Spring Boot Test.

Run all unit and controller tests using:

```bash
mvn test
```

To run a specific test class:

```bash
mvn -Dtest=HelloWorldServiceImplTest test
```

```bash
mvn -Dtest=HelloWorldControllerTest test
```

The tests cover:

- First character validation (A–M and N–Z).
- Uppercase and lowercase characters.
- Null and empty input handling.
- HTTP success and bad request responses.
- Internal server error handling.
- Unexpected service responses.

## Assumptions

1. The API accepts a name as a required query parameter.
2. Only English alphabetic characters (A–Z) are considered valid starting characters.
3. Both uppercase and lowercase letters are supported.
4. Names starting with A–M return `SUCCESS`.
5. Names starting with N–Z return `FAILED`.
6. Null or empty names return an empty string from the service layer.
7. The controller returns HTTP 200 for successful requests, HTTP 400 for invalid requests, and HTTP 500 for unexpected exceptions.
8. The application uses Maven as its build tool and the default Spring Boot port (8080).
9. No database or external service is required.

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- JUnit 5
- Mockito
- MockMvc
- Maven