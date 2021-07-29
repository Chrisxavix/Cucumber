package StepsDefinitionTransactions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class StepTransactions {

    private WebDriver driver;
    /* Login */
    private By txtUser = By.xpath("//*[@id='ingreso']/input[1]");
    private By txtPassword = By.xpath("//*[@id='ingreso']/input[2]");
    private By btnSubmit = By.xpath("//*[@id='ingreso']/p[2]/input");
    /* Login - more options */
    private By linkMoreOptions = By.id("mas_opciones");
    private By btnForceClose = By.id("cierre");
    /* Formulario */
    private By messageOk = By.id("entorno-estatus-contenido");
    private By txtCode = By.id("entorno-pt");
    private By messageStatus = By.id("entorno-estatus-contenido");

    @Given("Abre el web browser Chrome y direcciona a la aplicacion$")
    public void openBrowser() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/ue0100066b/Documentos/Chris/TestingCourse/Extraido/Chrome-Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://10.1.115.64:8380/WEB3/ingreso.html");
    }

    @When("Selecciono cierre de sesiones activas$")
    public void selectMoreOptions()throws Throwable {
        Thread.sleep(3000);
        driver.findElement(linkMoreOptions).click();
    }

    @When("Ingreso el usuario \"([^\"]*)\" y la contrasena \"([^\"]*)\"$")
    public void typeUserPassword(String user, String password)throws Throwable {
        driver.findElement(txtUser).sendKeys(user);
        driver.findElement(txtPassword).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(btnSubmit).click();
    }

    @When("Ingreso la transaccion \"([^\"]*)\"$")
    public void typeTransaction(String transaction) throws Throwable {
        Thread.sleep(2000);
        driver.findElement(txtCode).sendKeys(transaction);
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.moveToElement(driver.findElement(txtCode));
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
    }

    @Then("Marco forzar cierre$")
    public void selectForceClose()throws Throwable {
        Thread.sleep(2000);
        WebElement selectOptions = driver.findElement(btnForceClose);
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", selectOptions);
    }

    @Then("Visualizo el menu principal$")
    public void viewForm()throws Throwable {
        String resultText = driver.findElement(messageOk).getText();
        if (resultText.equals("OK")) {
            System.out.println("Éxito al cargar el menú principal, " + resultText);
        } else {
            System.out.println("Error al cargar el menú principal, " + resultText);
        }
    }

    @Then("Visualizo el estado de la transaccion$")
    public void viewStatusForm()throws Throwable {
        int cont = 1;
        String resultText = driver.findElement(messageStatus).getText();
        while (resultText.equals("CARGANDO FORMULARIO...") && cont <= 3) {
            Thread.sleep(1000);
            cont++;
            resultText = driver.findElement(messageStatus).getText();
        }
        if (resultText.equals("CARGANDO FORMULARIO...")) {
            System.out.println("Time Out, Error al cargar el formulario, " + resultText);
        } else {
            String [] vect = resultText.split(" ");
            if (vect[0].equals("NO")) {
                /* Mensaje de que no Existe el Formulario 0000 */
                System.out.println("Error, " + resultText);
            } else if (vect[1].equals("CARGADO")) {
                /* Mensaje de éxito de carga de Formulario 0000 */
                System.out.println("Éxito, " + resultText);
            } else {
                /* Diferentes errores de validación */
                System.out.println(resultText);
            }
        }
    }

    @And("Cierro el Browser$")
    public void closeBrowser() throws Throwable {
        Thread.sleep(3000);
        driver.close();
    }
}
