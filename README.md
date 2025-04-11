# 🧙‍♂️ Sistema de Gerenciamento de RPG

Este projeto é um sistema de gerenciamento para um jogo de RPG desenvolvido em **Java com Spring Boot**. Ele permite o cadastro e gerenciamento de **personagens** e **itens mágicos**, com regras específicas para cada tipo de item.

##  Tecnologias Utilizadas

- Java Spring Boot
  - Spring Web
  - Spring Data JPA
- H2 Database (banco de dados em memória)
- Swagger (documentação dos endpoints)

---

Dependencia: org.springdoc

Artefato: springdoc-openapi-starter-webmvc-ui

Vesao: 2.1.0


# Link para testar as Rotas
http://localhost:8080/swagger-ui/index.html#/


# configurações de Progeto

# Configurações do H2
spring.datasource.url=jdbc:h2:mem:cinema

spring.datasource.driver-class-name=org.h2.Driver

spring.datasource.username=sa

spring.datasource.password=

spring.h2.console.enabled=true

spring.h2.console.path=/h2-console

# Configurações do JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.jpa.hibernate.ddl-auto=update

# Configurações do Swagger
springdoc.api-docs.path=/api-docs




