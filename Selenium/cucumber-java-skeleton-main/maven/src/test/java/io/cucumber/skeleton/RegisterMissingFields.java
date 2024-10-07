package io.cucumber.skeleton;

import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterMissingFields {
    WebDriver driver;
    RegisterPage registerPage;

    @Given("the user is on the registration page for missing fields")
    public void the_user_is_on_the_registration_page_for_missing_fields_scenario() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
        driver.get("https://demo.automationtesting.in/Index.html");

        registerPage.clickSkipSignIn();
    }

    @When("the user leaves some fields empty")
    public void the_user_leaves_some_fields_empty() throws InterruptedException {
        registerPage.enterFirstName("SeuNome");
        registerPage.enterLastName("Sobrenome");
        registerPage.enterEmail("email@example.com");
        Thread.sleep(1000);
    }

    @When("submits the form with missing fields")
    public void submits_the_form_with_missing_fields() throws InterruptedException {
        registerPage.scrollToSubmitButton();
        Thread.sleep(1000);
        registerPage.clickSubmit();
    }

    @Then("an error message should be displayed for the missing fields")
    public void an_error_message_should_be_displayed_for_the_missing_fields() throws InterruptedException {
        Thread.sleep(1000);
        String phoneValidationMessage = registerPage.getHtml5RequiredMessageByFieldXpath("//input[@type='tel']");

        System.out.printf(phoneValidationMessage);

        assertEquals("Preencha este campo.", phoneValidationMessage);
        driver.quit();
    }
}
