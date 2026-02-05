# Resort Management System

A comprehensive Spring Boot-based Resort Management System designed to streamline operations across multiple departments of a resort or hotel property.

## 🏨 Overview

The Resort Management System is an enterprise-level Java application built with Spring Boot that provides integrated solutions for managing various aspects of a resort's operations. The system follows a modular architecture with separate modules for different functional areas.

## 📋 Features

### Core Modules

- **Billing Module** - Invoice generation, payment processing, and financial reporting
- **Booking Module** - Reservation management and check-in/check-out processes
- **Room Management** - Room inventory, availability tracking, and maintenance scheduling
- **F&B (Food & Beverage)** - Restaurant and bar operations, menu management
- **Human Resources** - Employee management, payroll, and scheduling
- **Inventory Management** - Stock tracking across departments
- **Marketing** - Campaign management and guest engagement
- **Pricing** - Dynamic pricing, rate management, and promotions
- **Reporting** - Business intelligence and analytics dashboards
- **Support** - Guest services and issue tracking
- **Common Components** - Shared utilities, enums, exception handling, and mappers

### Technical Features

- **RESTful API** - Comprehensive REST endpoints for all operations
- **Spring Security** - Authentication and authorization
- **JPA/Hibernate** - Object-relational mapping
- **MySQL Database** - Relational data persistence
- **Database Migrations** - Flyway for version control of database schemas
- **Lombok** - Reduce boilerplate code
- **DevTools** - Development enhancements for faster development cycles

## 🛠️ Technology Stack

| Technology | Version |
|-----------|---------|
| Java | 21 |
| Spring Boot | 4.0.2 |
| Spring Data JPA - dependency | 4.0.2 |
| Spring Security - dependency | 4.0.2 |
| Spring Web MVC - dependency | 4.0.2 |
| MySQL Driver - dependency | Latest |
| Validation - dependency| Latest |
| Lombok - dependency | Latest |
| Flyway - dependency | Latest |
| Maven | 3.6+ |

## 📦 Project Structure

```
resort-management-system/
├── src/
│   ├── main/
│   │   ├── java/com/resortmanagement/system/
│   │   │   ├── billing/              # Billing & payments
│   │   │   ├── booking/              # Reservations & check-ins
│   │   │   ├── room/                 # Room management
│   │   │   ├── fnb/                  # Food & Beverage operations
│   │   │   ├── hr/                   # Human Resources
│   │   │   ├── inventory/            # Inventory management
│   │   │   ├── marketing/            # Marketing campaigns
│   │   │   ├── pricing/              # Dynamic pricing
│   │   │   ├── reporting/            # Reports & analytics
│   │   │   ├── support/              # Guest support
│   │   │   ├── common/               # Shared utilities
│   │   │   │   ├── audit/            # Audit logging
│   │   │   │   ├── constants/        # Application constants
│   │   │   │   ├── enums/            # Enumeration types
│   │   │   │   ├── exception/        # Exception classes
│   │   │   │   ├── mapper/           # Data mappers
│   │   │   │   └── util/             # Utility functions
│   │   │   └── config/               # Application configuration
│   │   └── resources/
│   │       ├── application.properties # Configuration
│   │       ├── db/migration/         # Flyway migrations
│   │       ├── static/               # Static assets
│   │       └── templates/            # Thymeleaf templates
│   └── test/
│       └── java/                     # Unit & integration tests
├── pom.xml                           # Maven configuration
└── README.md                         # This file
```

## 🚀 Getting Started

### Prerequisites

- **Java 21** or higher
- **Maven 3.6** or higher
- **MySQL 8.0** or higher
- **Git** for version control

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/resort-management-system.git
   cd resort-management-system/system
   ```

2. **Configure the database**
   
   Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/resort_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=validate
   spring.jpa.show-sql=false
   ```

3. **Build the project**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   
   The application will start on `http://localhost:8080`

### Using Maven Wrapper

If you prefer not to install Maven separately:

```bash
# On Windows
mvnw.cmd clean install
mvnw.cmd spring-boot:run

# On Linux/macOS
./mvnw clean install
./mvnw spring-boot:run
```

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api
```

### Main Endpoints

| Module | Base Path | Description |
|--------|-----------|-------------|
| Billing | `/api/billing` | Payment and invoice management |
| Booking | `/api/booking` | Reservation management |
| Room | `/api/room` | Room operations |
| F&B | `/api/fnb` | Food & Beverage services |
| HR | `/api/hr` | Human Resources |
| Inventory | `/api/inventory` | Stock management |
| Marketing | `/api/marketing` | Marketing operations |
| Pricing | `/api/pricing` | Price management |
| Reporting | `/api/reporting` | Reports and analytics |
| Support | `/api/support` | Guest support services |

## 🔐 Security

The system implements Spring Security with:
- Authentication and authorization
- Role-based access control (RBAC)
- Secure password storage
- CSRF protection
- Request validation

### Default Roles

- `ADMIN` - Full system access
- `MANAGER` - Department management access
- `STAFF` - Operational access
- `GUEST` - Limited guest-facing features

## 🗄️ Database

The system uses MySQL with Flyway for schema management. Database migrations are automatically applied on application startup.

**Migration Location**: `src/main/resources/db/migration/`

To add a new migration:
1. Create a new file following the naming convention: `V{version}_{description}.sql`
2. Place it in the migration directory
3. Restart the application

## 🧪 Testing

Run unit and integration tests:

```bash
mvn test
```

Run tests with coverage:

```bash
mvn test jacoco:report
```

## 🔧 Configuration

### Application Properties

Key configuration properties in `application.properties`:

```properties
# Server
server.port=8080
server.servlet.context-path=/

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/resort_db
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Application Name
spring.application.name=system
```

## 📝 Development

### IDE Setup

For IntelliJ IDEA:
1. Open the project
2. Maven should auto-detect `pom.xml`
3. Enable Annotation Processing for Lombok (Preferences > Compiler > Annotation Processors > Enable)

For Eclipse:
1. Install Lombok plugin
2. Run `mvn eclipse:eclipse`
3. Import the project

### Code Style

The project uses:
- **Lombok** to reduce boilerplate
- **Spring conventions** for naming and structure
- **JPA best practices** for database operations

## 🐛 Troubleshooting

### Database Connection Issues
- Ensure MySQL is running
- Verify credentials in `application.properties`
- Check database exists: `CREATE DATABASE resort_db;`

### Compilation Errors
- Ensure Java 21 is installed: `java -version`
- Clear Maven cache: `mvn clean`
- Rebuild: `mvn install`

### Port Already in Use
- Change port in `application.properties`: `server.port=8081`
- Or kill process on port 8080

## 📄 Module Documentation

Each module contains its own `README.md` with specific documentation:

- [Billing README](src/main/java/com/resortmanagement/system/billing/README.md)
- [Booking README](src/main/java/com/resortmanagement/system/booking/README.md)
- [Room README](src/main/java/com/resortmanagement/system/room/README.md)
- And more...

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Contribution Guidelines

- Follow the existing code structure and naming conventions
- Write unit tests for new features
- Update documentation for significant changes
- Ensure all tests pass before submitting PR
- Keep commits atomic and descriptive

## 📊 Project Status

- **Version**: 0.0.1-SNAPSHOT (Development)
- **Status**: Active Development
- **Java**: 21
- **Spring Boot**: 4.0.2

## 📋 Roadmap

- [ ] Complete core module implementations
- [ ] Add comprehensive API documentation (Swagger/OpenAPI)
- [ ] Implement advanced reporting features
- [ ] Add mobile app support
- [ ] Performance optimization
- [ ] Enhanced security features (2FA, OAuth2)

## 📞 Support

For issues and questions:
1. Check existing GitHub issues
2. Create a new issue with detailed description
3. Include error logs and system information

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

Created for resort and hotel management operations.

## 🙏 Acknowledgments

- Spring Boot and Spring Framework communities
- MySQL community
- Lombok project
- All contributors and users

---

**Last Updated**: February 2026
**Maintainers**: [Your Team Name]

For more information, visit the [Wiki](https://github.com/yourusername/resort-management-system/wiki) or check the module-specific READMEs in the source tree.
