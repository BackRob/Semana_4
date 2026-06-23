# Sistema de Gestión de Tours - LlanquihueTourApp

## Descripción

LlanquihueTourApp es una aplicación desarrollada en Java que permite gestionar información de tours turísticos mediante una estructura organizada por capas. El sistema implementa conceptos de Programación Orientada a Objetos, manejo de archivos, validación de datos y persistencia en archivos de texto.

La aplicación carga automáticamente los tours almacenados en un archivo `.txt`, permitiendo realizar búsquedas, filtros y almacenamiento de nuevos registros de manera sencilla.

## Tecnologías Utilizadas

- Java
- Maven
- IntelliJ IDEA
- Archivos de texto (.txt)
- Programación Orientada a Objetos (POO)

## Estructura del Proyecto

```
Semana_4
│
├── src
│   └── main
│       └── LlanquihueTourApp
│           ├── data
│           │   └── GestionDatos.java
│           │
│           ├── model
│           │   └── Tour.java
│           │
│           ├── resources
│           │   └── tours.txt
│           │
│           └── ui
│               └── Main.java
│
├── test
├── pom.xml
└── README.md
```

## Funcionalidades

### Gestión de Tours

El sistema permite administrar tours turísticos mediante objetos de la clase `Tour`, que almacenan:

- Nombre del tour.
- Tipo de tour.
- Precio del tour.

### Carga Automática de Datos

Al iniciar la aplicación se cargan automáticamente los datos almacenados en el archivo `tours.txt`.

Durante la lectura se realizan validaciones para detectar:

- Campos vacíos.
- Cantidad incorrecta de datos.
- Errores en el formato del precio.
- Problemas de lectura o ausencia del archivo.

Además, se genera un informe indicando la cantidad de registros cargados correctamente y los errores detectados.

### Persistencia de Datos

La aplicación permite:

- Agregar nuevos tours al archivo.
- Mantener sincronizada la información entre el archivo y la memoria.
- Sobrescribir completamente el archivo cuando sea necesario actualizar los registros.

### Búsqueda de Tours

Se pueden realizar búsquedas utilizando distintos criterios:

- Búsqueda por nombre.
- Búsqueda por tipo.

Las búsquedas no distinguen entre mayúsculas y minúsculas.

### Filtro por Precio

El sistema permite filtrar tours según su precio utilizando operadores de comparación:

- Mayor que (>)
- Mayor o igual que (>=)
- Menor que (<)
- Menor o igual que (<=)

## Modelo de Datos

### Clase Tour

Representa un tour turístico dentro del sistema.

Atributos:

| Atributo | Tipo |
|-----------|---------|
| nombre | String |
| tipo | String |
| precio | double |

Características:

- Constructor por defecto.
- Constructor parametrizado.
- Métodos getters y setters.
- Validación de datos.
- Método `toString()` sobrescrito.

## Conceptos Aplicados

Durante el desarrollo de este proyecto se aplicaron los siguientes conceptos:

- Programación Orientada a Objetos.
- Encapsulamiento.
- Constructores y sobrecarga de constructores.
- Manejo de colecciones mediante ArrayList.
- Lectura y escritura de archivos.
- Manejo de excepciones.
- Validación de datos.
- Persistencia de información.
- Separación de responsabilidades por capas.

## Ejecución

### Clonar el repositorio

```bash
git clone https://github.com/BackRob/Semana_4.git
```

### Compilar el proyecto

```bash
mvn compile
```

### Ejecutar la aplicación

Ejecutar la clase:

```java
Main.java
```

o mediante Maven según la configuración del proyecto.

## Autor

Brian Vallejos

Proyecto académico desarrollado para la asignatura de Programación, enfocado en la aplicación de Programación Orientada a Objetos, gestión de datos y persistencia en archivos de texto.