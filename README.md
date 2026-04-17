# OumuamuaObservation: Full-Stack Records Management System

A robust RESTful API built with Spring Boot and C++ integration, designed for real-time observation data management. Featuring automated validation, in-memory H2 database persistence, and secure remote access via ngrok tunnels.
## Tech Stack
Backend: Spring Boot (Java), Microsoft C++ Integration.

Database: H2 In-Memory Database.

Documentation: OpenAPI / Swagger (SpringDoc).

DevOps: Linux environment, ngrok tunneling.

## Features

- REST API for observations with CRUD operations
- Validation for observation date and details
- H2 in-memory database with sample data
- OpenAPI documentation via SpringDoc
- H2 console enabled at `/h2-console`

## Run

```bash
./mvnw spring-boot:run
```

## Endpoints

- `GET /api/observations`
- `GET /api/observations/{id}`
- `POST /api/observations`
- `PUT /api/observations/{id}`
- `DELETE /api/observations/{id}`

## Notes

- JSON dates use the `yyyy-MM-dd` format.
- Validation errors return a JSON response describing the invalid fields.

## Access from other devices

By default the app binds to all network interfaces, so you can open it from another device on the same local network using `http://<YOUR_PC_IP>:8080/`.

Example:

```bash
# find local IP on Linux
hostname -I
```

Then use the returned IP address, such as:

```text
http://192.168.1.50:8080/
```

If the other device is not on your network, use a tunnel tool such as `ngrok`:

```bash
./run-ngrok.sh
```

Then open the generated public URL in the remote device.

> Make sure your firewall allows port `8080`, or use `ngrok` for a temporary secure tunnel.

This project serves as the Capstone for my Associate of Applied Science in Applications Development at Houston Community College.
