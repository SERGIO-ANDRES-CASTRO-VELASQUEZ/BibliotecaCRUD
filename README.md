# Sistema de Gestión de Biblioteca 📚

Una aplicación web desarrollada en Spring Boot para la gestión de libros en una biblioteca, implementando operaciones CRUD completas con una arquitectura bien estructurada.

## 🚀 Características

- **Gestión completa de libros**: Crear, leer, actualizar y eliminar registros de libros
- **API RESTful**: Endpoints bien definidos para todas las operaciones
- **Base de datos**: Persistencia de datos con JPA/Hibernate
- **Validaciones**: Validación de datos de entrada y manejo de excepciones
- **Arquitectura por capas**: Separación clara de responsabilidades

## 🛠️ Tecnologías Utilizadas

- **Java** 17+
- **Spring Boot** 3.5.5
- **Spring Data JPA**
- **Spring Web**
- **PostGreSQL** (para desarrollo local)
- **Maven** (gestión de dependencias)

## 📋 Requisitos Previos

Antes de ejecutar la aplicación, asegúrate de tener instalado:

- **Java JDK 17** o superior
- **Maven 3.3.3**
- **Git** (para clonar el repositorio)

## 🔧 Instalación y Configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/SERGIO-ANDRES-CASTRO-VELASQUEZ/BibliotecaCRUD.git
cd BibliotecaCRUD
```

### 2. Verificar la instalación de Java

```bash
java -version
mvn -version
```

### 3. Compilar el proyecto

```bash
mvn clean compile
```

## 🚀 Despliegue Local

### Opción 1: Usando Maven

```bash
mvn spring-boot:run
```

### Opción 2: Ejecutando el JAR

```bash
# Generar el JAR
mvn clean package

# Ejecutar la aplicación
java -jar target/BibliotecaCRUD-1.0.0.jar
```

### Opción 3: Desde el IDE

Ejecutar la clase principal `BibliotecaApplication.java` directamente desde tu IDE favorito.

## 🌐 Acceso a la Aplicación

Una vez iniciada la aplicación, estará disponible en:

- **URL base**: `localhost:8099/api/biblioteca`
- **Configuracion Postgresql**:
  - URL: `jdbc:postgresql://localhost:5432/biblioteca`
  - Usuario: `postgresql`
  - Contraseña: `tu_contraseña`

## 📍 Endpoints de la API

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/biblioteca` | Obtener todos los libros |
| GET | `/api/biblioteca/{id}` | Obtener libro por ID |
| GET | `/api/biblioteca/autor?nombres=nombre_autor` | Obtener libro por Autor |
| POST | `/api/biblioteca/crearLibro` | Crear nuevo libro |
| POST | `/api/biblioteca/crearVariosLibros` | Crear varios libros tipo lista |
| PUT | `/api/biblioteca/{id}` | Actualizar libro existente |
| DELETE | `/api/biblioteca/{id}` | Eliminar libro |

### Ejemplo de JSON para crear/actualizar libro:

```json
{
	"titulo" : "la ceguera blanca",
    "nombresAutor" : "castro",
    "anioPublicacion" : 2005,
    "disponible" : true
}
```

## 🏗️ Estructura del Proyecto

```
src/
├── main/
│ ├── java/
│ │   └── com/biblioteca/bibliotecacrud/
│ │       ├── BibliotecaCrudApplication.java
│ │       ├── controller/
│ │       │   └── LibroController.java
│ │       ├── entity/
│ │       │   └── Libro.java
│ │       ├── exception/
│ │       │   ├── EntityNotFoundException.java
│ │       │   ├── ExceptionResponse.java
│ │       │   └── ResponseExceptionHandler.java
│ │       ├── repository/
│ │       │   └── LibroRepo.java
│ │       └── service/
│ │           └── LibroService.java
│ └── resources/
│ └── application.properties
└── test/
```

## 👥 Equipo de Desarrollo y Responsabilidades

### Juan Carlos Restrepo Penagos 🔧
**Responsabilidad: Capa de Servicio (Service)**
- Implementación de la lógica de negocio
- Servicios para operaciones CRUD de libros
- Validaciones de negocio
- Interfaz entre controladores y repositorios

### Cristian Steven Casanova Anacona  🎮
**Responsabilidad: Capa de Control (Controller)**
- Desarrollo de controladores REST
- Definición y mapeo de endpoints
- Manejo de peticiones HTTP

### Santiago Alarcón Gutiérrez 🗄️
**Responsabilidad: Repositorio y Configuración (Repository & Properties)**
- Implementación de repositorios JPA
- Configuración de base de datos
- Archivo `application.properties`
- Query personalizada

### Sergio Andrés Castro Velásquez 📊
**Responsabilidad: Entidades y Manejo de Excepciones (Entity & Exceptions)**
- Diseño y implementación de entidades JPA
- Mapeo objeto-relacional
- Clases de excepción personalizadas
- Manejo de errores

## 📝 Configuración

El archivo `application.properties` contiene las configuraciones principales:

```properties
spring.application.name=bibliotecaCRUD
spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca
spring.datasource.username=postgres
spring.datasource.password=admin
spring.datasource.driver-class-name=org.postgresql.Driver
server.port=8099
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 🐛 Solución de Problemas

### Error de puerto ocupado
Si el puerto 8099 está ocupado, cambia el puerto en `application.properties`:
```properties
server.port=8081
```

### Error de Java version
Verifica que estés usando Java 17 o superior:
```bash
java -version
```

### Error de dependencias Maven
Limpia y reinstala las dependencias:
```bash
mvn clean install -U
```
---

⭐ ¡No olvides darle una estrella al repositorio si te fue útil!
