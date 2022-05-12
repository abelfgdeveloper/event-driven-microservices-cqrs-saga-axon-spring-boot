# event-driven-microservices-cqrs-saga-axon-spring-boot
Codigo del curso de Udemy [Event-Driven Microservices, CQRS, SAGA, Axon, Spring Boot](https://www.udemy.com/course/spring-boot-microservices-cqrs-saga-axon-framework/)

# Microservicios y Puertos
Microservicio  | Puerto
------------- | -------------
products-service  | Random
discovery-server  | 8761
gateway-server  | 8090
axon-server  | 8024


# Arrancar Axon Server como Jar
Lo descargamos desde [aqui](https://download.axoniq.io/axonserver/AxonServer-4.5.12.zip)

Lo descomprimimos y ejecutamos
```
java -java .\axonserver.jar
```
# Arrancar Axon Server con Docker

```
docker run --name axonserver -p 8024:8024 -p 8124:8124 -v d:\develop\docker-data\axonserver\data:/data -v d:\develop\docker-data\axonserver\eventdata:/eventdata -v d:\develop\docker-data\axonserver\config:/config axoniq/axonserver
```