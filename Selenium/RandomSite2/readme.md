# Projeto de Teste com Selenium

Este projeto demonstra um teste simples com Selenium para a página de login do OrangeHRM usando JUnit 5. O teste valida a funcionalidade de login verificando credenciais inválidas e navegando para a página de redefinição de senha.

## Recursos

- Teste automatizado de login para OrangeHRM
- Validação de credenciais de login incorretas
- Navegação para a página de redefinição de senha

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para escrever os testes.
- **Selenium WebDriver**: Framework de automação de navegador.
- **JUnit 5**: Framework de testes para Java.
- **ChromeDriver**: WebDriver para o navegador Chrome.
- **Allure**: Framework de testes para  que auxilia na visualização dos resultados dos testes.

## Instruções de Configuração

Para configurar este projeto, siga os passos abaixo:

Abra um terminal e navegue até a pasta raiz do projeto.

mvn clean install

mvn test

mvn allure:report

mvn allure:serve
