# SpringProject Parameta

## Descripción

Este proyecto es una aplicación Spring que implementa una API REST para gestionar empleados. La aplicación incluye validaciones para los campos de entrada, garantizando que todos los datos requeridos sean válidos antes de su procesamiento.

## Endpoint

Puedes utilizar el siguiente formato para hacer una llamada al endpoint:

http://localhost:8080/api/employees/create?nombres=Edward&apellidos=Hernandez&tipoDocumento=CC&numeroDocumento=123456789&birthDate=1998-11-24&joinDate=2023-07-01&cargo=Dev&salario=3500



## Requisitos

Asegúrate de tener instalados los siguientes componentes:

- **Java**: Versión 17 o superior
- **Maven**: Para gestionar las dependencias y construir el proyecto
- **MySQL**: Para almacenar la información de los empleados

## Configuración de la Base de Datos

Antes de iniciar la aplicación, es necesario crear una base de datos MySQL llamada `parameta` y configurar el archivo `application.properties` con los datos de tu servidor MySQL. 

### Configuración del archivo `application.properties`

Actualiza las siguientes propiedades en tu archivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/parameta
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASENA

Query para crear la base de datos
Puedes crear la base de datos ejecutando la siguiente consulta SQL:

sql
CREATE DATABASE parameta;
