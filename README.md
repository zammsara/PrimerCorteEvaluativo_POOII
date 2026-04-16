# 📱 Mis Recargas

## 📖 Descripción
**Mis Recargas** es una aplicación móvil desarrollada con **Kotlin** y **Jetpack Compose** que permite registrar y visualizar recargas telefónicas de forma rápida y organizada.  

Su objetivo principal es ayudar al usuario a llevar un control del dinero invertido en saldo móvil mediante una interfaz moderna, intuitiva y basada en **Material Design 3**.

---

## 🎯 Objetivo
Desarrollar una aplicación funcional, accesible y visualmente clara que permita:
- Registrar múltiples recargas telefónicas  
- Gestionar información de manera sencilla  
- Consultar un historial organizado de recargas  

---

## 🛠️ Tecnologías utilizadas
- **Kotlin**
- **Jetpack Compose**
- **Material Design 3**

---

## ⚙️ Funcionalidades
- 📲 Registro de recargas telefónicas  
- ☎️ Ingreso de número de teléfono  
- 💰 Ingreso del monto de la recarga  
- 📡 Selección de compañía telefónica mediante menú desplegable  
- 🔔 Mensaje dinámico según la acción del usuario  
- 🧠 Almacenamiento temporal de múltiples recargas  
- 📋 Visualización del historial en tarjetas  

---

## 🧩 Componentes utilizados
La interfaz está construida utilizando los siguientes componentes de Jetpack Compose:

- **Scaffold** → Estructura principal de la pantalla  
- **TopAppBar** → Encabezado de la aplicación  
- **Card** → Contenedor para formulario e historial  
- **OutlinedTextField** → Entrada de datos  
- **ExposedDropdownMenuBox** → Selección de compañía  
- **Button** → Acción de registro  
- **LazyColumn** → Listas dinámicas  
- **Text** → Visualización de información  

---

## 🧠 Gestión de estado
La aplicación utiliza `remember` para gestionar:
- Los datos ingresados por el usuario  
- La lista de recargas registradas en memoria  

Esto permite una actualización reactiva de la interfaz sin necesidad de recargar la pantalla.

---

## 🎨 Diseño de interfaz
El diseño sigue los principios de **Material Design 3**, destacando:

- 🎨 Paleta de colores verdes (claridad, confianza y organización)  
- 📐 Jerarquía visual clara  
- 📏 Espaciado adecuado entre componentes  
- 🔤 Uso consistente de tipografía  
- ♿ Contraste adecuado para accesibilidad  

---

## 🧱 Estructura de la pantalla
1. Encabezado con el título **"Mis Recargas"**  
2. Formulario de registro dentro de una **Card**  
3. Botón para registrar la recarga  
4. Mensaje dinámico de retroalimentación  
5. Sección de historial de recargas  
6. Lista dinámica mostrada en tarjetas  

---

## ✅ Conclusión
La aplicación cumple con los requerimientos planteados, integrando correctamente:
- Componentes interactivos  
- Gestión de estado  
- Principios modernos de diseño  

Se obtiene una interfaz funcional y escalable que puede evolucionar hacia una aplicación más completa en el futuro.
