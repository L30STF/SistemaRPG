# 🧙‍♂️ Sistema de Gerenciamento de RPG

Este projeto é um sistema de gerenciamento para um jogo de RPG desenvolvido em **Java com Spring Boot**. Ele permite o cadastro e gerenciamento de **personagens** e **itens mágicos**, com regras específicas para cada tipo de item.

# Tecnologias Utilizadas
   java Spring Boot
   
   Banco de dados H2 (in-memory)


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




Endpoints

Personagem

Método	Endpoint	Descrição	Corpo da Requisição (JSON)

POST	/personagens	Cadastra um personagem	{ "nome": "Argon", "nomeAventureiro": "Passolago", "classe": "GUERREIRO", "level": 5, "forcaBase": 6, "defesaBase": 4, "itensMagicos": [] }

GET	/personagens	Lista todos os personagens	-

GET	/personagens/{id}	Busca personagem por ID	-

PUT	/personagens/{id}/nome-aventureiro	Atualiza nome aventureiro	"NovoNome"

DELETE	/personagens/{id}	Remove personagem	-
POST	/personagens/{id}/itens	Adiciona item ao personagem	1 (ID do item)
DELETE	/personagens/{id}/itens/{itemId}	Remove item do personagem	-
GET	/personagens/{id}/itens	Lista itens do personagem	-
GET	/personagens/{id}/amuleto	Busca amuleto do personagem	-
Item Mágico
Método	Endpoint	Descrição	Corpo da Requisição (JSON)
POST	/itens-magicos	Cadastra um item mágico	{ "nome": "Espada Flamejante", "tipo": "ARMA", "forca": 2, "defesa": 0 }
GET	/itens-magicos	Lista todos os itens mágicos	-
GET	/itens-magicos/{id}	Busca item mágico por ID	-

springdoc.swagger-ui.path=/swagger-ui.html



