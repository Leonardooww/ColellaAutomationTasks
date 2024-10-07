# Posts API Test Automation

Este projeto é um conjunto de testes automatizados para a API de posts do [JSONPlaceholder](http://jsonplaceholder.typicode.com). Utilizando RestAssured e JUnit 5, o objetivo é garantir que a API esteja funcionando conforme o esperado, validando os campos retornados e o status das respostas.

## Funcionalidades

- Validação de todos os campos retornados pela API para cada post.
- Verificação do código de status HTTP retornado pela API.
- Testes específicos para o primeiro post, incluindo `userId`, `id`, `title` e `body`.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Maven**: Gerenciador de dependências e build.
- **RestAssured**: Biblioteca para testes de API REST.
- **JUnit 5**: Framework de testes unitários.
- **Allure**: Ferramenta para geração de relatórios de testes.

## Pré-requisitos

Antes de executar o projeto, certifique-se de que você tem o seguinte instalado:

- [Java JDK 11 ou superior](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)

## Como Executar os Testes

Abra um terminal e navegue até a pasta raiz do projeto.

mvn clean install

mvn test

mvn allure:report

mvn allure:serve
