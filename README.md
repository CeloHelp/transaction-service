# Transaction Service

Microsserviço desenvolvido com **Java + Spring Boot** para gerenciar operações relacionadas a transações em uma arquitetura baseada em microsserviços.

Este projeto faz parte de um estudo prático voltado à **comunicação entre serviços**, **resiliência**, **fallback** e **observabilidade com logs**, atuando em conjunto com o `customer-service`.

## Objetivo

O `transaction-service` foi criado para representar o domínio de transações em uma arquitetura distribuída, permitindo simular fluxos entre diferentes contextos de negócio.

Além da lógica principal do serviço, o projeto também foi utilizado para estudar:

- comunicação entre microsserviços
- desacoplamento entre responsabilidades
- logs e rastreabilidade
- resiliência em chamadas externas
- fallback em cenários de falha

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok
- OpenFeign
- Resilience4j
- Logback / SLF4J

## Principais responsabilidades do serviço

- Registro e consulta de transações
- Persistência de dados em banco relacional
- Integração com outros microsserviços
- Tratamento de falhas em comunicação
- Fallback para cenários de indisponibilidade
- Geração de logs para rastreamento das operações

## Estrutura do projeto

A aplicação foi organizada em camadas para facilitar manutenção, testes e evolução:

- **controller**: endpoints REST
- **service**: regras de negócio
- **repository**: acesso a dados
- **entity/model**: domínio da aplicação
- **client/integration**: comunicação entre serviços

## Comunicação com outros serviços

O `transaction-service` interage com o `customer-service` para simular cenários reais de comunicação em arquitetura distribuída.

Esse contexto foi utilizado para estudar:

- troca de informações entre serviços
- dependência entre domínios
- tratamento de falhas
- fallback
- comportamento da aplicação em integrações instáveis

## Resiliência e observabilidade

Este projeto foi importante para consolidar estudos ligados à robustez de microsserviços, como:

- tratamento de erros de integração
- fallback para respostas controladas
- logs para diagnóstico
- rastreabilidade de requisições
- previsibilidade em cenários de falha

## Como executar o projeto

### Pré-requisitos

- Java 17+
- Maven
- PostgreSQL
- IDE de sua preferência

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/CeloHelp/transaction-service.git
```

2. Acesse a pasta do projeto:

```bash
cd transaction-service
```

3. Configure as propriedades do banco de dados no arquivo `application.yml`.

4. Execute o projeto:

```bash
./mvnw spring-boot:run
```

Ou:

```bash
mvn spring-boot:run
```

## Aprendizados com este projeto

Com este microsserviço, aprofundei conhecimentos em:

- microsserviços com Spring Boot
- comunicação entre serviços
- logs e observabilidade
- fallback e resiliência
- separação de contexto de negócio
- organização de aplicações distribuídas

## Repositório relacionado

Este projeto faz parte do estudo em conjunto com:

- [customer-service](https://github.com/CeloHelp/customer-service)

## Autor

**Marcelo Henrique Pacobello**  
[LinkedIn](https://www.linkedin.com/in/marcelo-henrique-pacobello)  
[GitHub](https://github.com/CeloHelp)
