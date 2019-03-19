# README #

This project is a definition of an application for a technical test for the company **Dextra**.
The main goal of this project is to create an API to handle sales of sandwiches. 

### PROJECT REQUIREMENTS ###

* Java 8
* Maven 3.3.9

### HOW TO CONFIGURE ###

1. Import the project as maven project using an IDEA

### HOW TO RUN AS WEB APPLICATION ###

1. Execute **mvn install** inside of the **root folder**
2. Execute **mvn spring-boot:run** inside of the **root folder**
3. Use the following address **http://localhost:8080/** to access the API endpoints.

### ENDPOINTS ###

##### CLENTS #####

* **GET** /clients
* **GET** /clients/{id}
* **POST** /clients
* **PUT** /clients/{id}
* **DELETE** /clients/{id}

##### INGREDIENTS #####
* **GET** /ingredients
* **GET** /ingredients/{id}

##### REQUESTS #####
* **GET** /requests
* **GET** /requests/{id}
* **POST** /requests
* **PUT** /requests/{id}
* **DELETE** /requests/{id}

##### SANDWICHES #####
* **GET** /sandwiches
* **GET** /sandwiches/{id}