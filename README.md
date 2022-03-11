## Backend Challenge Coodesh

Este é um desafio para que possamos ver as suas habilidades como Back-end Developer.
Nesse desafio você deverá desenvolver uma REST API que utilizará os dados do projeto 
Space Flight News, uma API pública com informações relacionadas a voos espaciais. 
O projeto a ser desenvolvido por você tem como objetivo criar a API permitindo assim a 
conexão de outras aplicações.

## Repositório do Desafio

* https://lab.coodesh.com/public-challenges/back-end-challenge-2021

## Tecnologias utilizadas
* Kotlin
* Springboot
* Postgres
* Hibernate
* Maven

## Bibliotecas utilizadas
* Rest Assured
* OpenFeing
* DevTools
* Scheduled (Job)
* Hateoas

1 - Criando a rede no docker

```
docker network create backend-challenge-net
```

2 - Executando uma instância do banco postgres

```
docker run -p 5432:5432 --name backend-challenge-pg
--network backend-challenge-net 
-e POSTGRES_PASSWORD=1234567 
-e POSTGRES_DB=db_backend_challenge 
postgres:12-alpine
````

3 - No arquivo application.properties descomente as 4 primeiras linhas para gerar o arquivo create.sql que contém a estrutura do banco de dados.

```
#spring.jpa.properties.javax.persistence.schema-generation.create-source=metadata
#spring.jpa.properties.javax.persistence.schema-generation.scripts.action=create
#spring.jpa.properties.javax.persistence.schema-generation.scripts.create-target=create.sql
#spring.jpa.properties.hibernate.hbm2ddl.delimiter=;
```
4 - Execute os comandos SQL's dentro de algum client, como por exemplo PGAdmin 4


