# Config Domain

Purpose
- Central configuration beans used across the application: async executors, JPA settings, security and API docs.

Interactions with other domains
- Injects config beans used by services and controllers across domains (e.g., executors, audit configuration).

Key artifacts
- `AsyncConfig.java`, `JpaConfig.java`, `SecurityConfig.java`, `SwaggerConfig.java`

Transaction boundaries
- Configuration is infrastructure; the beans themselves should be stateless and thread-safe.

Auditing, soft delete, concurrency
- **Auditing**: `JpaConfig` should enable JPA auditing via `AuditorAwareImpl`.
- **Concurrency**: `AsyncConfig` should define bounded executors for background tasks.

Security roles
- `SecurityConfig` defines roles and protects endpoints.

Design patterns used
- Factory: produce beans for common cross-cutting concerns.

Typical workflows
- Application startup wires config beans and enables auditing, security, and scheduled tasks.

Notes
- Keep configuration classes minimal and environment-driven via properties.
