import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Teste de Login")
@Feature("Login na página do OrangeHRM")
public class SeleniumTest {
    private WebDriver driver;

    @BeforeEach
    @Step("Inicializando o navegador")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Story("Validar todos os campos do retorno da API")
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Teste de login com credenciais inválidas")
    @Step("Testando login com credenciais inválidas")
    public void testLogin() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
        Thread.sleep(1500);

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Admin");
        Allure.step("Preenchendo campo de usuário");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Admin1234");
        Allure.step("Preenchendo campo de senha");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
        Allure.step("Clicando no botão de login");

        Thread.sleep(1500);
        WebElement warningWrongPass = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
        assertEquals("Invalid credentials", warningWrongPass.getText());
        Allure.step("Verificando mensagem de erro: " + warningWrongPass.getText());

        WebElement forgotPassHyperLink = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p"));
        forgotPassHyperLink.click();
        Allure.step("Clicando no link de 'Esqueci a senha'");

        Thread.sleep(1500);
        WebElement resetPassPageIndicator = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/h6"));
        assertEquals("Reset Password", resetPassPageIndicator.getText());
        Allure.step("Verificando se a página de redefinição de senha é exibida: " + resetPassPageIndicator.getText());

        WebElement newUsernameField = driver.findElement(By.name("username"));
        newUsernameField.sendKeys("Admin");
        Allure.step("Preenchendo campo de usuário para redefinição");

        driver.findElement(By.tagName("button")).click();
        Allure.step("Clicando no botão para redefinir a senha");
    }

    @AfterEach
    @Step("Fechando o navegador")
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
