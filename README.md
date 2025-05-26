# ConstructZAF

**ConstructZAF** es una plataforma web diseñada para facilitar la gestión y el alquiler de herramientas y equipos de construcción. Permite a contratistas, empresas y particulares alquilar maquinaria específica sin necesidad de adquirirla. Automatiza procesos de reservas, pagos, devoluciones y gestión de inventarios para los proveedores.

---

## 🎯 Objetivos

- Automatizar la gestión de alquileres y reservas.
- Mejorar el control de inventarios para proveedores.
- Ofrecer una experiencia de usuario intuitiva para clientes, proveedores y administradores.

---

## 🛠️ Tecnologías Utilizadas

**Backend:**

- Java 21
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL
- WebSockets

**Frontend:**

- HTML
- CSS
- JavaScript

---

## 🚀 Instalación y Ejecución del Proyecto

### 1. Clonar el Repositorio

```bash
git clone https://github.com/Alejandra2070/Backend_ConstructZAF.git
```


### 3. Frontend

Abrir el archivo `index.html` ubicado en la carpeta `/frontend` en su navegador preferido.

---

![Captura de pantalla 2025-05-26 080256](https://github.com/user-attachments/assets/68104db6-5af9-47df-9d01-a6516cfcdefa)


## ⚙️ Configuración `application.properties`

```properties
spring.application.name=project

server.port=8080

# Autenticación
spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/ConstructZAF
spring.sql.init.encoding=UTF-8
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=org.postgresql.Driver

# Setup JPA
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop
spring.sql.init.mode=always
```

---

## 🗃️ Diagrama Relacional

![Captura de pantalla 2025-05-26 074458](https://github.com/user-attachments/assets/6fd26fa6-c489-4ce5-b6c9-b91ad1b15140)


---

## 📌 Endpoints de la API

### Autenticación

```http
POST localhost:8080/auth/registro
```

**Request:**

```json
{
  "username": "",
  "password": ""
}
```

**Response:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIs..."
}
```

---

### Herramientas

```http
GET localhost:8080/construc/herramientas
POST localhost:8080/construc/herramientas
PUT localhost:8080/construc/herramientas/{id}
DELETE localhost:8080/construc/herramientas{id}
```

---

### Reservas

```http
GET localhost:8080/construc/reservas
POST localhost:8080/construc/herramientas
```

---

### Alquiler

```http
GET localhost:8080/construc/alquiler
POST localhost:8080/construc/alquiler
```

---

## 🔐 Autenticación y Roles

La autenticación se realiza mediante **JWT**. Los roles definidos en el sistema son:

- **ADMIN**: Control total del sistema.
- **PROVEEDORES**: Gestionan inventario, herramientas y reportes.
- **USER**: Pueden alquilar, reservar y pagar herramientas.

Cada petición debe incluir el token JWT en la cabecera:

```http
Authorization: Bearer <token>
```

---

### Notion
Para información mas detallada del proyecto:
> https://www.notion.so/ConstructZAF-1f25e5ca87568066bae6eba5fb4c92e4?pvs=4
## 👥 Desarrollado por

Estudiantes de CampusLands:

- Alejandra Machuca
- Jean Franco Guerrero
- Zully Fernanda Ortiz Avendaño

