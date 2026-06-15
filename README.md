# 🧭 Semana_4 - Gestión de Tours en Java

Aplicación básica desarrollada en Java como parte de la actividad de Programación Orientada a Objetos. Permite crear, guardar y gestionar tours utilizando archivos de texto.

---

## 🚀 Funcionalidades

- Crear objetos tipo `Tour`
- Guardar información en archivo `.txt`
- Leer datos desde archivo
- Manejo de archivos con `BufferedWriter` y `BufferedReader`
- Uso de listas (`ArrayList`)
- Separación por capas (model, data)

---

## 🏗️ Estructura del proyecto

Semana_4/
│
├── src/
│   ├── data/
│   │    ├── SaveTours.java
│   │    └── LoadTours.java
│   │
│   ├── model/
│   │    └── Tour.java
│   │
│   ├── ui/
│   │    └── Main.java
│
├── resources/
│   └── tours.txt
│
├── README.md
└── .gitignore

---

## 📦 Clases principales

### Tour
Representa un tour con:
- nombre
- tipo
- precio

---

### SaveTours
Clase encargada de guardar los datos en el archivo `tours.txt`.

Formato:
Nombre,Tipo,Precio

---

### LoadTours
Clase encargada de **leer los datos del archivo** y convertirlos en objetos `Tour`.

🔎 ¿Qué hace?
- Lee el archivo línea por línea usando `BufferedReader`
- Separa cada línea (por ejemplo con `split(",")`)
- Convierte los datos en objetos `Tour`
- Guarda los objetos en una lista (`ArrayList`)

👉 Ejemplo:
Archivo:
```
Llanquihue,Aventura,50000
Valle Nevado,Nieve,80000
```

Se transforma en:
- Tour("Llanquihue", "Aventura", 50000)
- Tour("Valle Nevado", "Nieve", 80000)

Esto es posible porque en Java los archivos se pueden leer línea por línea usando `BufferedReader.readLine()` y luego procesar cada texto 【1-9e6538】【2-ee5fb4】

---

## 💻 Tecnologías

- Java
- POO
- java.io (BufferedReader / BufferedWriter)

---

## ▶️ Ejecución

1. Clonar repositorio  https://github.com/BackRob/Semana_4
2. Abrir en IntelliJ o IDE similar  
3. Ejecutar clase principal  

---

## ⚠️ Notas

- Usa `newLine()` para evitar que los datos se peguen
- Archivo se crea automáticamente si no existe
- `LoadTours` convierte texto en objetos

---

## 🧠 Aprendizajes

- Clases y objetos  
- Lectura y escritura de archivos  
- Uso de colecciones (`ArrayList`)  
- Separación de responsabilidades  

---

## ✍️ Autor

BackRob/Brian Vallejos
``
