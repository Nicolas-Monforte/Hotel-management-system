# Sistema de Gestión de Reservas de Hotel

## Descripción
Este proyecto es un sistema de gestión de reservas de hotel desarrollado en **Java** utilizando el paradigma de programación orientada a objetos (POO). Permite gestionar habitaciones, pasajeros y reservas de forma eficiente, brindando funcionalidades completas de CRUD y consulta de disponibilidad.

### Patrón DAO
El sistema utiliza el patrón **DAO** para interactuar con la base de datos MySQL. Cada entidad del sistema (Habitaciones, Pasajeros y Reservas) tiene su propia clase DAO, lo que permite realizar operaciones de CRUD (Crear, Leer, Actualizar, Eliminar) de manera encapsulada y reutilizable.

## Funcionalidades
- **CRUD completo** para:
  - Habitaciones
  - Pasajeros
  - Reservas
- Consulta de disponibilidad de habitaciones en un período específico.
- Gestión de habitaciones con características como:
  - Número de habitación
  - Capacidad (camas single y dobles)
  - Precio por día
- Gestión de reservas que incluye:
  - Fechas de check-in y check-out
  - Pasajero principal
  - Seña
  - Habitaciones reservadas

## Tecnologías utilizadas
- **Lenguaje:** Java 21
- **Base de datos:** MySQL (usando JDBC para la persistencia)
- **IDE:** NetBeans
- **Patrón de diseño:** MVC (Modelo-Vista-Controlador)

## Requisitos
- **Java JDK 21** o superior
- **MySQL Workbench** (para gestionar la base de datos)
- Configuración de conexión a la base de datos en el archivo de configuración

