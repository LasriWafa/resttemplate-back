# Back-end: API REST Employés

## I. Description
Ce projet constitue la partie Back-end du TP. Il s'agit d'une application Spring Boot exposant une API RESTful pour gérer des employés.

## II. Configuration du Projet
-   **Nom du projet** : `resttemplate-back`
-   **Port** : `9090`
-   **Base de données** : H2 In-Memory

### Dépendances (pom.xml)
-   `spring-boot-starter-data-jpa` : Pour la couche persistance.
-   `spring-boot-starter-web` : Pour créer l'API REST.
-   `spring-boot-starter-validation` : Pour la validation des données.
-   `lombok` : Pour réduire le code boilerplate.
-   `h2` : Base de données.
-   `modelmapper` : Pour le mapping Entité <-> DTO (VO).
-   `jackson-dataformat-xml` : Pour le support XML.

## III. Structure de l'Application

### 1. Entités et Modèles
-   **`Emp`** : Entité JPA représentant un employé (id, nom, salaire, fonction).
-   **`EmpVo`** : Value Object (DTO) exposé via l'API.

### 2. Couche DAO & Service
-   **`EmpRepository`** : Interface étendant `JpaRepository` pour les opérations CRUD et requêtes personnalisées (par salaire, par fonction, etc.).
-   **`IService` / `ServiceImpl`** : Couche métier contenant la logique et l'utilisation de `ModelMapper` pour la conversion Entité/DTO.

### 3. Contrôleur REST (`EmpRestController`)
Ce contrôleur expose les endpoints suivants :
-   `GET /rest/emp` : Liste de tous les employés (JSON/XML).
-   `GET /rest/emp/id/{id}` : Récupérer un employé par ID.
-   `GET /rest/emp/name/{name}` : Rechercher par nom.
-   `POST /rest/emp` : Créer un nouvel employé.
-   `PUT /rest/emp/{id}` : Mettre à jour un employé.
-   `DELETE /rest/emp/{id}` : Supprimer un employé.
-   `GET /rest/sort/{fieldName}` : Trier les employés.
-   `GET /rest/pagination/{pageid}/{size}` : Liste paginée.

## IV. Lancement
1.  Importer le projet Maven.
2.  Exécuter la classe `MainApplication`.
3.  Accéder à la console H2 : `http://localhost:9090/h2-console`
4.  Tester l'API via Postman ou navigateur : `http://localhost:9090/rest/emp`
