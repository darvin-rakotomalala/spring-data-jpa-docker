## Spring Data JPA | Docker Compose
Dans ce repo, nous utiliserons **Docker Compose** pour exécuter un exemple CRUD Spring Boot Data JPA et PostgreSQL.

### Technologies
---
- Java 11
- Spring Boot 2.7.7
- Spring Data JPA
- Lombok
- MapStruct
- Maven 3+
- PostgreSQL

### Exécuter et tester le projet
---
- Pour générer le fichier JAR, exécutez : `mvn clean install -DskipTests=true`
- Démarrer d'abord la base de données avec Docker Compose : `docker-compose up dbpostgresql`
- Puis démarrer l'application avec Docker Compose : `docker-compose up app_mcs`
- Importer dans Postman la collection `socle_jpa.postman_collection.json` pour tester les APIs
- Vous pouver utiliser aussi l'url du Swagger ou importer l'url Swagger dans Postman
  - Les descriptions OpenAPI seront disponibles au chemin /v3/api-docs par défaut : http://localhost:8081/v3/api-docs/ et/ou http://localhost:8081/swagger-ui/index.html
