# Projeto de Teste com Selenium

Este projeto demonstra um teste simples com Selenium para a página de registro do https://demo.automationtesting.in/Register.html usando JUnit 5. O teste valida a funcionalidade de registro.

## Recursos

- Teste automatizado de registro para https://demo.automationtesting.in/Register.html
- Validação de sucesso de registro para campos corretos.
- Validação de erro durante tentativa de registro com telefone inválido.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para escrever os testes.
- **Selenium WebDriver**: Framework de automação de navegador.
- **JUnit 5**: Framework de testes para Java.
- **Allure**: Framework de testes para  que auxilia na visualização dos resultados dos testes.
- **Cucumber**: Behavior-Driven Development, reutilização de código e visualização simplificada dos testes cases. Given When Then.
- **ChromeDriver**: WebDriver para o navegador Chrome.

## Instruções de Configuração

Para configurar este projeto, siga os passos abaixo:

Abra um terminal e navegue até a pasta raiz do projeto.

mvn clean install

mvn test

mvn allure:report

mvn allure:serve
