# API Automation Project – JSONPlaceholder

## Overview
This project contains automated API tests for the **JSONPlaceholder** public API ([https://jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com)) using:

- **Java**
- **Rest Assured**
- **Cucumber**
- **JUnit**

The tests cover full CRUD operations on the `/posts` endpoint.

---

## Features Tested

- **Retrieve all posts** (`GET /posts`)
- **Retrieve a single post by ID** (`GET /posts/{id}`)
- **Create a new post** (`POST /posts`)
- **Update a post** (`PUT /posts/{id}`)
- **Delete a post** (`DELETE /posts/{id}`)

**Assertions include:**

- HTTP status codes
- Response body content (`id`, `title`, `body`, `userId`)
- Response headers (where applicable)
- Validation of exact field values
- Logging of request/response payloads in Cucumber reports

---
## Prerequisites

- Java 11 or higher
- Maven 3.6+
- IDE (IntelliJ, Eclipse, VS Code, etc.)
- Internet connection (for accessing JSONPlaceholder API)

---

## Setup

1. Open the repository in IDE
2. Install dependencies:

mvn clean install

## Running Tests
From Maven:
mvn clean test

From IDE:

Right-click on TestRunner.java → Run

## Test Reports

HTML report: target/cucumber-reports.html

JSON report: target/cucumber-reports.json

Console output: printed for each step

Note: Request and response payloads are logged in the Cucumber report using hooks.