package io.cucumber.skeleton;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {
    WebDriver driver;
    RegisterPage registerPage;

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
        driver.get("https://demo.automationtesting.in/Index.html");

        registerPage.clickSkipSignIn();
    }

    @When("the user fills in the registration form")
    public void the_user_fills_in_the_registration_form() {
        registerPage.enterFirstName("SeuNome");
        registerPage.enterLastName("Sobrenome");
        registerPage.enterAddress("Endereço de Exemplo");
        registerPage.enterEmail("email@example.com");
        registerPage.enterPhone("1234567890");
        registerPage.selectGender("Male");
        registerPage.selectHobbies("Movies");
        registerPage.selectSkills("Java");
        registerPage.selectCountry("India");
        registerPage.selectBirthDate("1990", "June", "10");
        registerPage.enterPassword("SenhaForte123", "SenhaForte123");
    }

    @When("submits the form")
    public void submits_the_form() throws InterruptedException {
        Thread.sleep(1000);
        registerPage.scrollToSubmitButton();
        Thread.sleep(1000);
        registerPage.clickSubmit();
    }

    @Then("the user should be registered successfully")
    public void the_user_should_be_registered_successfully() {
        driver.quit();
    }
}
