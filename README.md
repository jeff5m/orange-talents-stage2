![GitHub Workflow Status](https://img.shields.io/github/workflow/status/jeff5m/orange-talents-stage2/build-and-test) 
![Docker Image Size (tag)](https://img.shields.io/docker/image-size/jeff5m/orange-talents-stage2)
# Desafio Técnico da segunda fase do programa Orange Talents
## 💬️ Contexto
Você está fazendo uma API REST que precisará controlar endereços de usuários.

O primeiro passo deve ser a construção de um cadastro de usuários, sendo obrigatório dados como: nome, e-mail, CPF e data de nascimento, onde e-mail e CPF devem ser únicos.

> - _**Nome**_
> - _**E-mail (Único)**_
> - _**CPF (Único)**_
> - _**Data de nascimento**_

O segundo passo é criar um cadastro de endereços, sendo obrigatório dados mínimos para cadastro como: logradouro, número, complemento, bairro, cidade, estado e CEP, associando este endereço ao usuário.

> - _**Logradouro**_
> - _**Número**_
> - _**Complemento**_
> - _**Bairro**_
> - _**Cidade**_
> - _**Estado**_
> - _**CEP**_

Por fim, criar um endpoint que retornará um usuário com a lista de todos seus endereços cadastrados.

## 🛎 Endpoints
Todos os endpoints são precedidos de `http://localhost:8080/`

#### User
- /user `POST`
- /users/{id}/addresses `GET`

#### Address
- /address `POST`

## 🧪 Testando a aplicação
Existem três `profiles` para testes:

#### 1. Testes de unidade:
Navegue pelo terminal até a pasta raiz do projeto e execute o comando:
```sh
./mvnw test -P unit-tests
```
#### 2. Testes de integração:
Navegue pelo terminal até a pasta raiz do projeto e execute o comando:
```sh
./mvnw test -P integration-tests
```
#### 3. Todos os testes:
Navegue pelo terminal até a pasta raiz do projeto e execute o comando:
```sh
./mvnw test -P all-tests
```

## ✅ Executando o projeto 

### 1. 🐋 Utilizando docker
Primeiro é necessário criar os volumes para persistência dos dados. Navegue pelo terminal até a pasta raiz do projeto e 
execute o 
comando:
```sh
docker-compose up -d
```
Depois:
```sh
docker-compose up
```
### 2. 🖥 Utilizando o maven
Nesse caso, é necessário ter o banco MySQL rodando na máquina local. Após verificar se ele está instalado,
Navegue pelo terminal até a pasta raiz do projeto e execute o comando:
```sh
 ./mvnw clean install
```
E depois
```sh
 ./mvnw spring-boot:run
```
## 📄 Documentação
A documentação da API, com a descrição de cada endpoint e seus possiveis retornos está disponível no link:

```sh
http://localhost:8080/swagger-ui.html
```

## 🔧 Desenvolvimento
Tecnologias em uso no projeto:

* ☕️ **Java 11**
* 🌱 **Spring (Boot, Data JPA)**
* 🐋 **Docker**
* 📄 **Swagger**