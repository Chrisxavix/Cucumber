package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Steps {
    private WebDriver driver;

    private By txtUser = By.xpath("//*[@id='ingreso']/input[1]");
    private By txtPassword = By.xpath("//*[@id='ingreso']/input[2]");
    private By btnSubmit = By.xpath("//*[@id='ingreso']/p[2]/input");
    private By txtCode = By.id("entorno-pt");
    private By messageStatus = By.id("entorno-estatus-contenido");

    @Given("Abre el web browser Chrome y direcciona a la aplicacion$")
    public void openBrowser() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/ue0100066b/Documentos/Chris/TestingCourse/Extraido/Chrome-Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://10.1.115.64:8380/WEB3/ingreso.html");
    }

    @When("Ingreso el usuario y clave$")
    public void typeUserPassword() throws Throwable {
        driver.findElement(txtUser).sendKeys("UE0100066B");
        driver.findElement(txtPassword).sendKeys("chris012345");
        Thread.sleep(3000);
        driver.findElement(btnSubmit).click();
        Thread.sleep(3000);
        driver.findElement(txtCode).sendKeys("04-6003");
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(txtCode));
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
    }

    @Then("Visualizo resultado$")
    public void viewResults()throws Throwable {
        Thread.sleep(3000);
        String resultText = driver.findElement(messageStatus).getText();
        System.out.println("Resultado: " + resultText);
    }

    @And("Cierro el Browser$")
    public void closeBrowser() throws Throwable {
        System.out.println("Cerrando el browser...");
        /*driver.close();*/
    }
}
