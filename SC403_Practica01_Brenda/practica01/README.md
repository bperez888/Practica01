# practica01 – Catálogo de suculentas (CRUD)

Aplicación web en **Spring Boot 3 (Java 17)** con **Thymeleaf, Bootstrap 5, JPA/Hibernate y MySQL**, arquitectura MVC.

## Requisitos
- JDK 17+
- Maven 3.9+ (o el que provea el IDE)
- MySQL 8 + MySQL Workbench

## Pasos de ejecución
1. Abrir `sql/practica.sql` en MySQL Workbench y ejecutarlo completo (como `root`).
   Crea la base `practica`, la tabla `suculenta`, el usuario `usuario_practica` (clave `la_Clave`) y 8 registros de prueba.
2. Abrir el proyecto en el IDE o desde consola: `mvn spring-boot:run`
3. Abrir <http://localhost:91>

## Estructura
```
com.practica01
 ├─ domain/       Suculenta (entidad JPA)
 ├─ repository/   SuculentaRepository
 ├─ service/      SuculentaService + SuculentaServiceImpl
 └─ controller/   SuculentaController, IndexController
templates/
 ├─ layout/plantilla.html   (head+Bootstrap, encabezado/menú, mensajes, pie, scripts)
 └─ suculenta/              listado, nueva, modifica, formulario (fragmento de campos)
```

## Rutas
| Ruta | Método | Acción |
|---|---|---|
| `/suculenta/listado` | GET | Listado dinámico |
| `/suculenta/nueva` | GET | Formulario de creación |
| `/suculenta/guardar` | POST | Crea o actualiza |
| `/suculenta/modificar/{id}` | GET | Formulario de edición |
| `/suculenta/eliminar/{id}` | POST | Elimina |

## Configuración (application.properties)
Puerto 91 · BD `practica` con `usuario_practica` · `logging.level.root=TRACE` · patrón de log `%d{dd HH:mm}` (día, hora, minuto).
Las imágenes se referencian por URL en la nube (columna `ruta_imagen`); no hay imágenes locales.
