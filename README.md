# Project-RomansDriving

<p align="center">
  <img src="RomansDriving/src/main/resources/static/img/Drive.png" alt="Project Logo">
</p>

## Descripción

Project-RomansDriving es una aplicación diseñada para mejorar la experiencia de conducción, proporcionando características avanzadas de asistencia al conductor y análisis de datos. Este proyecto combina tecnologías modernas para ofrecer una interfaz intuitiva y funcional.

## Nivel Usuario

**ADMIN** (usuario("admin")) , (contraseña("admin"))

**USUARIO** (usuario("user")) , (contraseña("1234"))

## Instalación

Para instalar y ejecutar el proyecto localmente, sigue estos pasos:

1. Clona el repositorio:
    ```bash
    git clone https://github.com/CarlosRomanAbad/Project-RomansDriving.git
    ```

2. Ejecuta tu id para lanzar la app, si no tienes aqui tienes una
    ```bash
    https://code.visualstudio.com/
    ```

3. Ejecute el programa desde
    ```bash
   src/main/java/RomansDrivingApplication.java
    ```

4. Inicia la aplicación en tu navegador con este enlace:
    ```bash
    http://localhost:9000
    ```

## Uso

Una vez que la aplicación esté en funcionamiento, podrás acceder a ella mediante tu navegador web en `http://localhost:9000`. Desde ahí, podrás explorar todas las funcionalidades que ofrece.
El usuario tendra la opcion de hacer reserva de clases servidas por un profesor y un vehiculo.
Tambien tendra la opcion de eliminarla en caso de errata. El programa no dejara eliminarla en el caso de que la fecha de la clase haya concurrido.

El administrador, aparte de hacer reserva de las clases, tendra la opcion de hacer gestion total de la autoescuela, pudiendo añadir , editar , o elminar, tanto vehiculos, como usuarios, como profesores, incluyendo clases. La eliminacion de las entidades no podran realizarse en caso de estas tengan asociadas una clase, por lo que hasta que la clase no se elimine, las entidades no podran ser eliminadas.
Tambien podra obtener informacion extra de la autoescuela, como el dinero ingresado con clases que han sido reservadas, o el profesor que mas clases tiene activas.

## Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactar a:

- **Carlos Roman Abad** - [Email](mailto:carlosromanabad@gmail.com)
- [GitHub](https://github.com/CarlosRomanAbad)

## Agradecimientos

Agradezco a https://github.com/lmlopezmagana , Ángel Naranjo González y Rafael Villar Liñán por las enseñanzas para poder realizar el proyecto
