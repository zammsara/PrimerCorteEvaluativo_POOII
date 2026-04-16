Mis Recargas
Descripción

Mis Recargas es una aplicación móvil desarrollada con Jetpack Compose que permite registrar y visualizar recargas telefónicas. La aplicación facilita el control del dinero invertido en saldo móvil mediante una interfaz moderna basada en Material Design 3.

Objetivo

Desarrollar una interfaz funcional, accesible y visualmente clara que permita al usuario registrar múltiples recargas telefónicas y consultar su historial de manera sencilla.

Tecnologías utilizadas
Kotlin
Jetpack Compose
Material Design 3
Funcionalidades
Registro de recargas telefónicas.
Ingreso de número de teléfono.
Ingreso del monto de la recarga.
Selección de compañía telefónica mediante menú desplegable.
Visualización de mensaje dinámico según la acción del usuario.
Almacenamiento temporal de múltiples recargas.
Visualización del historial de recargas en tarjetas (Card).
Componentes utilizados
Scaffold para la estructura principal de la interfaz.
TopAppBar para el encabezado de la aplicación.
Card para mostrar el formulario y el historial de recargas.
OutlinedTextField para la entrada de datos.
ExposedDropdownMenuBox para la selección de compañía.
Button para ejecutar la acción de registro.
LazyColumn para mostrar listas dinámicas.
Text para mostrar información y mensajes.
Gestión de estado

La aplicación utiliza remember para manejar el estado de los datos ingresados por el usuario, así como la lista de recargas registradas.

Diseño de interfaz

Se implementó una paleta de colores verdes para transmitir claridad, confianza y organización. Se respetaron principios de Material Design 3 como:

Jerarquía visual clara.
Espaciado adecuado entre componentes.
Uso consistente de tipografía.
Contraste adecuado para accesibilidad.
Estructura de la pantalla
Encabezado con el título "Mis Recargas".
Formulario de registro dentro de una Card.
Botón para registrar la recarga.
Mensaje dinámico de retroalimentación.
Sección de historial de recargas.
Lista dinámica de recargas mostradas en tarjetas.
Conclusión

La aplicación cumple con los requerimientos planteados, integrando correctamente componentes interactivos, gestión de estado y principios de diseño modernos. Se logra una interfaz funcional y escalable que puede evolucionar hacia una aplicación completa.
