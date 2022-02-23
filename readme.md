Documento de configuracón

1. El servicio rest fue creado con spring-boot 2.6.3
2. El servicio soap fue creado con spring-boot 2.6.3
3. La base de datos que consume el servicio soap esta alojada en la nube de AWS y el motor solicitado en el requerimiento
4. El servicio soap trabaja por el puerto 8080 y el servicio rest por el puerto 8090
5. Los proyectos estan creados con MAVEN
6. En el archivo llamado Parameta.postman_collection.json esta el esquema de ejemplo de invocacion del servicio rest
7. Se adiciona url de ejemplo del servicio rest

http://localhost:8090/empleador/nuevo/80188/CC/Mauricio/Lotero/24-4-1983/21-2-2010/Profesor/100000

8. El formato de los campos de fecha son dd-mm-yyyy
9. Para ejecutar los dos servicios se debe ejecutar el comando mvn spring-boot:run, en consolas independientes por cada servicio

