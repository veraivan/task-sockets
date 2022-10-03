## Requerimientos de instalación
 - Tener instalado JDK8 o superior
 - Postgresql v13
 
## Crear la base de datos
En la carpeta bd en el proyecto sys-suministro se encuentra el script.sql que debe de ejecutar en su postgres.

## Compilación y ejecución

Estando en la raiz del directorio ejecute lo siguiente: 
```sh
mvn clean package
```
Esto creara los archivos .jar de cada proyecto.


Para ejecución del cliente
```sh
java -jar cliente/target/cliente-1.0-SNAPSHOT.jar
```

Para ejecución del servidor
```sh
java -jar sys-suministro/target/sys-suministro-1.0-SNAPSHOT.jar
```