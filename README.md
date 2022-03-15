<h1 align="center">Backend Challenge Coodesh</h1>

##  ✅ Descrição do Projeto
<p align="center">Este é um desafio para que possamos ver as suas habilidades como Back-end Developer.
Nesse desafio você deverá desenvolver uma REST API que utilizará os dados do projeto 
Space Flight News, uma API pública com informações relacionadas a voos espaciais. 
O projeto a ser desenvolvido por você tem como objetivo criar a API permitindo assim a 
conexão de outras aplicações.</p>


<p align="center">
• <a href="#repositorio">Repositório do desafio</a> •
 <a href="#tecnologias">Tecnologias</a> •
 <a href="#bibliotecas">Bibliotecas</a> •
 <a href="#bibliotecas">Ferramentas</a> •
 <a href="#build">Build</a> •
</p>

##  ✅ Repositório do Desafio
* https://lab.coodesh.com/public-challenges/back-end-challenge-2021

##  🛠 Tecnologias
* [Kotlin](https://kotlinlang.org/)
* Springboot
* Postgres
* Hibernate
* Maven
* Docker

##  ✅ Bibliotecas
* Rest Assured
* OpenFeing
* DevTools
* Scheduled (Job)
* Hateoas

##  ✅ Ferramentas
* Postman
* IntelliJ IDEA
* PgAdmin 4

##  ✅ Features

- [x] Job para popular o banco de dados
- [x] Apis para listar todos e por id, cadastrar, atualizar e deletar artigos
- [x] Testes de integração utilizando RestAssured
- [ ] Documentação utilizando Swagger 3.0
- [ ] Tolerância a falhas ao consultar API externa


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

## 🎲 Rodando o Back End (servidor)

## ✅ Pré-requisitos e como rodar a aplicação/testes

## ✅ Demonstração da aplicação

### Autor
---

<a href="">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/4734174?s=420&v=10" width="100px;" alt=""/>
 <br />
 <sub><b>Alkxyly Samyr</b></sub></a> <a href="" title="Git Hub">🚀</a>


Feito com ❤️ por Alkxyly Samyr 👋🏽 Entre em contato!

[![Linkedin Badge](https://img.shields.io/badge/-Alkxyly-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/alkxyly/)](https://www.linkedin.com/in/alkxyly/)
[![Gmail Badge](https://img.shields.io/badge/-alkxyly@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:alkxyly@gmail.com)](mailto:tgmarinho@gmail.com)