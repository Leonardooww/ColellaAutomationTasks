package io.cucumber.skeleton;

import org.openqa.selenium.*;

import java.util.List;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSkipSignIn() {
        driver.findElement(By.id("btn2")).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
    }

    public void enterAddress(String address) {
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(address);
    }

    public void enterEmail(String email) {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
    }

    public void enterPhone(String phone) {
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(phone);
    }

    public void selectGender(String gender) {
        driver.findElement(By.xpath("//input[@value='" + gender + "']")).click();
    }

    public void selectHobbies(String hobby) {
        driver.findElement(By.id("checkbox2")).click();
    }

    public void selectSkills(String skill) {
        driver.findElement(By.id("Skills")).sendKeys(skill);
    }

    public void selectCountry(String country) {
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("country")).sendKeys(Keys.ENTER);  // Press Enter
    }

    public void selectBirthDate(String year, String month, String day) {
        driver.findElement(By.id("yearbox")).sendKeys(year);
        driver.findElement(By.xpath("//select[@placeholder='Month']")).sendKeys(month);
        driver.findElement(By.id("daybox")).sendKeys(day);
    }

    public void enterPassword(String password, String confirmPassword) {
        driver.findElement(By.id("firstpassword")).sendKeys(password);
        driver.findElement(By.id("secondpassword")).sendKeys(confirmPassword);
    }

    public void clickSubmit() {
        driver.findElement(By.id("submitbtn")).click();
    }

    public void scrollToSubmitButton() {
        WebElement submitButton = driver.findElement(By.id("submitbtn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
    }

    public String getHtml5RequiredMessageByFieldXpath(String xpath) {
        WebElement phoneField = driver.findElement(By.xpath(xpath));
        return phoneField.getAttribute("validationMessage");
    }
}
