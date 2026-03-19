# TaskManager - Persistencia con Room y Migraciones

## Autor

**Nombre:** Jhoseth Esneider Rozo Carrillo  
**Código:** 02230131027  
**Programa:** Ingeniería de Sistemas  
**Unidad:** Unidad 4 – JavaScript  
**Actividad:** Post-Contenido 1
**Fecha:** 18/03/2026

---

## Descripción del Proyecto

Aplicación Android desarrollada en lenguaje Kotlin que permite gestionar tareas (CRUD completo) utilizando **Room** como sistema de persistencia local.

El proyecto implementa una migración de base de datos de la versión 1 a la versión 2, garantizando la preservación de datos existentes mediante el uso de ALTER TABLE con un valor por defecto.

---

## Arquitectura

El proyecto sigue una arquitectura basada en MVVM (Model - View - ViewModel):

- **data/local/** → Entidades, DAO, Base de Datos y Migraciones
- **data/** → Repositorio
- **ui/** → ViewModel y UI (Jetpack Compose)

### Tecnologías utilizadas

- Kotlin
- Room Database
- Coroutines + Flow
- Jetpack Compose
- ViewModel

---

## Persistencia con Room

Se implementa Room con los siguientes componentes:

- `TaskEntity` → Representa la tabla `tasks`
- `TaskDao` → Define las operaciones CRUD
- `AppDatabase` → Base de datos principal
- `TaskRepository` → Abstracción de acceso a datos

---

## Migración de Base de Datos

### Versión 1

Estructura inicial de la tabla `tasks`:

- id
- title
- description
- isCompleted
- createdAt

### Versión 2

Se agrega el campo:

- `priority: Int` (valor por defecto = 1)

---

# Capturas del Resultado

## App corriendo con tareas en versión 1

![Captura lista de tareas](evidencias/captura_lista_tareas.png)

---

## JSON del esquema versión 2

![Captura esquema](evidencias/captura_esquema_v2.png)

---

## App corriendo tras la migración

![Captura datos migrados](evidencias/captura_datos_migrados.png)

---

## Test de migración aprobado

![Captura test migración](evidencias/captura_test_migration.png)
