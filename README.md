# NexusHR – AI-Enabled Enterprise HR & Workforce Intelligence Platform

NexusHR is an enterprise-grade Human Resources and Workforce Intelligence platform built using modern Spring Boot architecture.

---

## 🛠 Technology Stack

- **Language:** Java 21 (LTS)
- **Framework:** Spring Boot 3.3.4
- **Build Tool:** Maven 3.9+
- **Persistence:** Spring Data JPA / Hibernate
- **Database:** PostgreSQL (with runtime driver & in-memory H2 fallback for testing)
- **Security:** Spring Security (Stateless Foundation) & JJWT (JSON Web Token)
- **Validation:** Jakarta Bean Validation (Hibernate Validator)
- **Utility:** Project Lombok

---

## 📁 Package Architecture

```
com.nexushr
├── NexusHrApplication.java       # Main Spring Boot Application Entry Point
├── config/                       # Enterprise Security & App Configuration
│   └── SecurityConfig.java       # Spring Security stateless filter chain
├── controller/                   # REST API Controllers
│   └── HealthController.java     # System health and status endpoint
├── dto/                          # Data Transfer Objects & Response Envelopes
│   └── ApiResponse.java          # Standardized JSON response envelope
├── entity/                       # JPA Database Domain Entities (Phase 2)
├── repository/                   # Spring Data JPA Repositories (Phase 2)
├── service/                      # Business Logic Services (Phase 2)
└── exception/                    # Global Exception Handlers & Custom Errors
```

---

## ⚙️ Environment Variables & Configuration

The application is configured through environment variables with production-ready defaults. You can customize them via `.env` or system environment variables:

| Variable | Description | Default Value |
| :--- | :--- | :--- |
| `PORT` | Server HTTP Port | `8080` |
| `SPRING_PROFILES_ACTIVE` | Active Spring profile (`dev`, `prod`, `test`) | `dev` |
| `DB_HOST` | PostgreSQL Hostname | `localhost` |
| `DB_PORT` | PostgreSQL Port | `5432` |
| `DB_NAME` | PostgreSQL Database Name | `nexushr_db` |
| `DB_USERNAME` | PostgreSQL User | `postgres` |
| `DB_PASSWORD` | PostgreSQL Password | `postgres` |
| `DB_URL` | Full JDBC URL (Overrides host/port/name if set) | `jdbc:postgresql://localhost:5432/nexushr_db` |
| `JPA_DDL_AUTO` | Hibernate Schema Generation (`update`, `validate`, `none`) | `update` |
| `SHOW_SQL` | Log SQL queries to console | `false` |
| `JWT_SECRET` | 256-bit secret key for signing tokens | *(Preset 256-bit hex)* |
| `JWT_EXPIRATION_MS` | JWT expiration duration in milliseconds | `86400000` (24h) |

---

## 🚀 How to Run the Application

### 1. Prerequisites
- **Java 21** or newer JDK installed and set in `JAVA_HOME`.
- **Maven** (or use the configured Maven distribution in `.m2/apache-maven-3.9.9/bin`).
- *(Optional for full persistence)* **PostgreSQL** running locally on port `5432` with database `nexushr_db`.

### 2. Build and Test
Run a clean build and execute unit tests:
```bash
mvn clean test
```

### 3. Run Application

#### Standard Mode (PostgreSQL):
Ensure PostgreSQL is running and environment variables are set, then execute:
```bash
mvn spring-boot:run
```

#### Custom Configuration via Environment Variables:
In PowerShell / Command Prompt:
```powershell
$env:PORT = "8080"
$env:DB_HOST = "localhost"
$env:DB_NAME = "nexushr_db"
$env:DB_USERNAME = "postgres"
$env:DB_PASSWORD = "your_secure_password"
mvn spring-boot:run
```

#### Test Profile (In-Memory Database):
To boot in lightweight test mode without external PostgreSQL:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=test
```

---

## 🔍 Verification & Health Check

Once the application is running, test the health check endpoint:

- **Endpoint:** `GET http://localhost:8080/api/health`
- **Response:**
```json
{
  "success": true,
  "message": "NexusHR backend service is running successfully",
  "data": {
    "status": "UP",
    "platform": "NexusHR Workforce Intelligence Platform",
    "version": "0.0.1-SNAPSHOT",
    "timestamp": "2026-10-07T10:45:00"
  },
  "timestamp": "2026-10-07T10:45:00"
}
```
