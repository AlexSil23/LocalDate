# Práctica 4: Cumpleaños

Este programa Java calcula los días restantes hasta tu próximo cumpleaños.

## Descripción

La aplicación realiza las siguientes acciones:

1.  Muestra la fecha y hora actual en la consola, formateada en español.
2.  Solicita al usuario que ingrese su fecha de nacimiento en formato AAAA-MM-DD.
3.  Valida que la fecha introducida sea válida y no sea una fecha futura.
4.  Calcula los días que faltan para el próximo cumpleaños y muestra el resultado en la consola.
    * Tiene en cuenta si el cumpleaños del año en curso ya ha pasado para calcular correctamente los días restantes.

## Temas Utilizados

* **Módulo 3. Tema 4. API para fechas y localización:**
    * Se utilizan las clases `LocalDate` y `LocalDateTime` del paquete `java.time` para trabajar con fechas y horas.
    * Se utiliza `DateTimeFormatter` para formatear la fecha y hora actual en español y para formatear la fecha de nacimiento.
    * Se utiliza `Locale.forLanguageTag("es-ES")` para configurar el formateador en español.
    * Se utiliza `DateTimeParseException` para manejar errores de formato de fecha.
    * Se utiliza `Year.isLeap()` para determinar si un año es bisiesto.

## Cómo Ejecutar

1.  Asegúrate de tener instalado el JDK (Java Development Kit) en tu sistema.
2.  Compila el archivo `Cumpleaños.java` usando el comando `javac Cumpleaños.java`.
3.  Ejecuta el programa con el comando `java Cumpleaños`.
4.  Sigue las instrucciones en la consola para ingresar tu fecha de nacimiento.

