# 🚀 Mi Primer API Backend con Spring Boot (Proyecto Holamundo)

Este proyecto es una aplicación de ejemplo de API REST desarrollada con Spring Boot, diseñada para aprender los fundamentos del desarrollo backend con Java. Incluye la configuración básica de Spring Boot, la creación de controladores, el manejo de diferentes tipos de peticiones HTTP (GET, POST, PUT, DELETE), la gestión de parámetros de consulta y variables de ruta, y la persistencia de datos en una base de datos H2 en memoria utilizando Spring Data JPA.

---

## 🛠️ Tecnologías Utilizadas

* **Java 21** (o la versión de JDK que estés usando, ej. OpenJDK 17)
* **Spring Boot 3.x.x**
* **Maven** (como herramienta de construcción de proyectos)
* **Spring Web** (para construir APIs REST)
* **Spring Data JPA** (para interactuar con la base de datos)
* **Hibernate** (implementación ORM utilizada por Spring Data JPA)
* **H2 Database** (base de datos relacional incrustada en memoria para desarrollo y pruebas)
* **VS Code** (Entorno de Desarrollo Integrado)

---

## 🏁 Cómo Levantar el Proyecto

Sigue estos pasos para poner en marcha la aplicación en tu entorno local.

### Prerrequisitos

* **Java Development Kit (JDK) 21** (o 17+). Puedes verificarlo con `java -version`.
* **Maven** instalado. Puedes verificarlo con `mvn -v`.
* **VS Code** con la extensión "Extension Pack for Java".

### Pasos

1.  **Clona este repositorio** (o si lo descargaste directamente, descomprime el ZIP).
    ```bash
    git clone [https://github.com/ElAlgoritmoDeLaNoche/Backend-Java-de-0](https://github.com/ElAlgoritmoDeLaNoche/Backend-Java-de-0)
    cd holamundo
    ```

2.  **Abre el proyecto en VS Code.**
    * Abre VS Code.
    * Ve a `File` > `Open Folder...` y selecciona la carpeta `holamundo`.
    * VS Code debería reconocer automáticamente el proyecto Maven. Si se te pregunta, acepta importar el proyecto Maven.

3.  **Compila y ejecuta la aplicación Spring Boot.**
    * **Desde la Terminal Integrada de VS Code:**
        Asegúrate de estar en la raíz del proyecto (`holamundo`) y ejecuta:
        ```bash
        mvn spring-boot:run
        ```
    * **Desde VS Code (Java Projects/Run and Debug):**
        En la vista "Java Projects", expande tu proyecto `holamundo` y haz clic en el botón de `Run` junto a `holamundo` o `Run Spring Boot App`. Alternativamente, ve a la pestaña "Run and Debug" y selecciona la configuración de lanzamiento adecuada (Spring Boot App).

    La aplicación se iniciará y estará disponible en `http://localhost:8080`.

---

## 🧪 Endpoints de la API

La API expone los siguientes endpoints:

### 1. Controlador de Saludos (`HelloController`)

* **GET /hello**
    * Descripción: Retorna un mensaje de saludo simple.
    * Respuesta de ejemplo: `¡Hola desde Spring Boot con VS Code!`

* **GET /saludar?nombre={nombre}**
    * Descripción: Saluda a un nombre específico pasado como parámetro de consulta. Si `nombre` no se provee, saluda a "Mundo".
    * Parámetros de consulta:
        * `nombre` (opcional): Nombre a saludar.
    * Respuesta de ejemplo: `¡Hola, Alice!` o `¡Hola, Mundo!`

* **GET /mensaje/{id}**
    * Descripción: Retorna un mensaje genérico para un ID dado como variable de ruta.
    * Parámetros de ruta:
        * `id` (obligatorio): Identificador del mensaje.
    * Respuesta de ejemplo: `Has solicitado el mensaje con ID: 123`

### 2. Controlador de Productos (`ProductoController`)

Este controlador simula la gestión de productos con persistencia en una base de datos H2 en memoria. Los datos se reinician con cada ejecución de la aplicación.

* **GET /productos**
    * Descripción: Obtiene la lista de todos los productos disponibles.
    * Respuesta de ejemplo (JSON):
        ```json
        [
            { "id": 1, "nombre": "Laptop Gamer", "precio": 1200.50 },
            { "id": 2, "nombre": "Teclado Mecánico", "precio": 85.00 }
        ]
        ```

* **GET /productos/{id}**
    * Descripción: Obtiene un producto específico por su ID.
    * Parámetros de ruta:
        * `id` (obligatorio): ID del producto.
    * Respuesta de ejemplo (JSON):
        ```json
        { "id": 1, "nombre": "Laptop Gamer", "precio": 1200.50 }
        ```
    * Códigos de estado: `200 OK` (encontrado), `404 Not Found` (no encontrado).

* **POST /productos**
    * Descripción: Crea un nuevo producto. El ID es generado automáticamente por la base de datos.
    * Cuerpo de la petición (JSON):
        ```json
        {
            "nombre": "Auriculares Bluetooth",
            "precio": 99.99
        }
        ```
    * Respuesta de ejemplo (JSON - incluye el ID generado):
        ```json
        { "id": 4, "nombre": "Auriculares Bluetooth", "precio": 99.99 }
        ```
    * Códigos de estado: `201 Created`.

* **PUT /productos/{id}**
    * Descripción: Actualiza un producto existente por su ID.
    * Parámetros de ruta:
        * `id` (obligatorio): ID del producto a actualizar.
    * Cuerpo de la petición (JSON):
        ```json
        {
            "nombre": "Laptop Gamer PRO (Actualizada)",
            "precio": 1300.00
        }
        ```
    * Respuesta de ejemplo (JSON):
        ```json
        { "id": 1, "nombre": "Laptop Gamer PRO (Actualizada)", "precio": 1300.00 }
        ```
    * Códigos de estado: `200 OK` (actualizado), `404 Not Found` (no encontrado).

* **DELETE /productos/{id}**
    * Descripción: Elimina un producto por su ID.
    * Parámetros de ruta:
        * `id` (obligatorio): ID del producto a eliminar.
    * Respuesta: Sin contenido.
    * Códigos de estado: `204 No Content` (eliminado con éxito), `404 Not Found` (no encontrado).

---

## 📊 Consola de H2 Database (Solo para Desarrollo)

Mientras la aplicación está corriendo, puedes acceder a la consola web de la base de datos H2 para inspeccionar los datos directamente.

* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:testdb`
* **User Name:** `sa`
* **Password:** (dejar en blanco)

---

## 📈 Próximos Pasos (Opcional)

* **Validación de Entradas:** Asegurar que los datos recibidos sean válidos.
* **Manejo Global de Errores:** Centralizar la forma en que la API responde a diferentes tipos de errores.
* **Servicios (Services):** Introducir una capa de servicio para la lógica de negocio.
* **Bases de Datos Externas:** Conectar la aplicación a PostgreSQL, MySQL u otra base de datos persistente.
* **Seguridad:** Implementar autenticación y autorización (ej., Spring Security, JWT).
* **Contenerización:** Empaquetar la aplicación en un contenedor Docker.