# Log Management System

A lightweight, Redis-based log management system built with Spring Boot. 
It allows receiving, storing, and querying logs via RESTful APIs.

## ✨ Features

- 📥 Receive and store logs with timestamps, levels, messages, and sources
- 🔍 Query logs by Redis key
- 📃 List all logs (to be enhanced with pagination/search)
- 🗑️ Delete logs by key (coming soon)
- 📊 Log statistics by level/source (coming soon)
- 🌐 Web UI for viewing logs (optional future extension)

## 🛠 Tech Stack

- Java 17
- Spring Boot 3.x
- Redis
- Maven
- cURL or Postman for API testing

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Redis server running on localhost:6379
- Maven

### Build & Run

```bash
mvn spring-boot:run
```

### API Endpoints

- `POST /logs` - submit a log entry
- `GET /logs/{key}` - get log by Redis key
- `GET /logs` - list all logs

## 📦 Usage

- Start Redis server locally
- Run the Spring Boot application
- Use cURL/Postman to send logs to `POST /logs`
- Use `GET /logs/{key}` to retrieve specific logs
- Use `GET /logs` to list all logs

## 📁 Project Structure

- `LogEntry` - Model class for logs
- `LogService` - Logic for saving/querying logs from Redis
- `LogController` - REST API endpoints

## 📅 Last Updated

2025-03-28

---

Feel free to contribute, fork, or use this project in your own system monitoring tools 🚀
