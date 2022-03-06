"# backend-challenge--codestash"
## Repositório do Desafio
* https://lab.coodesh.com/public-challenges/back-end-challenge-2021

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


