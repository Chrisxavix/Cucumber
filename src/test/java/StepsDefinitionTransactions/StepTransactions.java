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
    /* Formulario Principal */
    private By messageOk = By.id("entorno-estatus-contenido");
    private By txtCode = By.id("entorno-pt");
    private By messageStatus = By.id("entorno-estatus-contenido");
    /* Transacción 05-2000 */
    /* Número de Solicitud */
    /*private By txtNumberRequest = By.xpath("//*[@id='container_1']/table/tbody/tr/td/input[1]");*/
    private By txtNumberRequest = By.id("c_F1csolicitud_0");
    /* Titulares - Cotitulares */
    private By selctTitCotiTd1_Identificacion = By.xpath("//*[@id='c_F2Id_0']");
    private By selctTitCotiTd2_Identificacion = By.xpath("//*[@id='c_F2Id_1']");
    private By selctTitCotiTd2_YO = By.xpath("//*[@id='c_F2Titularidad_1']");
    private By selctTitCotiTd1_Direccion = By.xpath("//*[@id='c_F2NumDireccion_0']");
    private By selctTitCotiTd2_Direccion = By.xpath("//*[@id='c_F2NumDireccion_1']");
    private By selctTitCotiTd2_Relacion = By.xpath("//*[@id='c_F2Crelacionp_1']");
    /* Datos de la Cuenta */
    private By selctAccData_Executive = By.xpath("//*[@id='c_F3Cusrcta_0']");
    private By selctAccData_Origin = By.xpath("//*[@id='c_F3CpropositoCDPC_0']");
    /* Datos del Certificado */
    private By selctCertData_Value = By.xpath("//*[@id='c_f7valor_0']");
    private By selctCertData_Frecuency = By.xpath("//*[@id='c_f7frecuencia_0']");
    private By selctCertData_DaysTerm = By.xpath("//*[@id='c_f7diasplazo_0']");
    private By btnCertData_Interest = By.xpath("//*[@id='c_F4Tasaboton_0']");
    private By btnCertData_CapitalizationInterest = By.xpath("//*[@id='c_F9RenoInteres_0']");
    private By btnCertData_DialogClose = By.xpath("//*[@id='entorno-formulario']/div[2]/form/div[11]/div[1]/img");
    /* Firmas */
    private By btnFirms_FirmTd1 = By.xpath("//*[@id='c_Btncopiar_0']");
    private By btnFirms_FirmTd2 = By.xpath("//*[@id='c_Btncopiar_1']");
    private By txtFirms_Firm = By.xpath("//*[@id='c_F4Identificacion_2']");
    /* Generar Reporte */
    private By btnGenRep_Generar = By.xpath("//*[@id='container_7']/table/tbody/tr/td/button");
    /* Opciones de tareas */
    private By btnSave = By.xpath("//*[@id='entorno-teclas']/button[9]");

    @Given("Abre el web browser Chrome y direcciona a la aplicacion$")
    public void openBrowser() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/ue0100066b/Documentos/Chris/TestingCourse/Extraido/Chrome-Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://10.1.115.64:8380/WEB3/ingreso.html");
    }

    @When("Selecciono cierre de sesiones activas$")
    public void selectMoreOptions()throws Throwable {
        Thread.sleep(2000);
        driver.findElement(linkMoreOptions).click();
        Thread.sleep(2000);
    }

    @Then("Marco forzar cierre$")
    public void selectForceClose()throws Throwable {
        WebElement selectOptions = driver.findElement(btnForceClose);
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", selectOptions);
        Thread.sleep(2000);
    }

    @When("Ingreso el usuario \"([^\"]*)\" y la contrasena \"([^\"]*)\"$")
    public void typeUserPassword(String user, String password)throws Throwable {
        driver.findElement(txtUser).sendKeys(user);
        Thread.sleep(2000);
        driver.findElement(txtPassword).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(btnSubmit).click();
        Thread.sleep(2000);
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

    @When("Ingreso la transaccion \"([^\"]*)\"$")
    public void typeTransaction(String transaction) throws Throwable {
        Actions actions = new Actions(driver);
        driver.findElement(txtCode).sendKeys(transaction);
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(txtCode));
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
        Thread.sleep(2000);
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

    @When("Lleno los datos generales de titulares y cotitulares$")
    public void typeTitularCotitular() throws Throwable {
        Actions actions = new Actions(driver);
        /* TD1 */
        /* Titutar */
        /* Identificación */
        WebElement identificacionTd1 = driver.findElement(selctTitCotiTd1_Identificacion);
        identificacionTd1.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        identificacionTd1.sendKeys("1704556644");
        Thread.sleep(1000);
        identificacionTd1.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Dirección */
        WebElement direcTd1 = driver.findElement(selctTitCotiTd1_Direccion);
        direcTd1.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        direcTd1.sendKeys("1");
        Thread.sleep(1000);
        direcTd1.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        /* TD2 */
        /* Cotitutar */
        /* Y/O */
        WebElement yoTd2 = driver.findElement(selctTitCotiTd2_YO);
        yoTd2.sendKeys("Y");
        Thread.sleep(2000);
        /* Identificación */
        WebElement identificacionTd2 = driver.findElement(selctTitCotiTd2_Identificacion);
        identificacionTd2.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        identificacionTd2.sendKeys("1100039401");
        Thread.sleep(1000);
        identificacionTd2.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Relación */
        WebElement relacionTd2 = driver.findElement(selctTitCotiTd2_Relacion);
        relacionTd2.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        relacionTd2.sendKeys("CTI");
        Thread.sleep(1000);
        relacionTd2.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Dirección */
        WebElement direcTd2 = driver.findElement(selctTitCotiTd2_Direccion);
        direcTd2.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        direcTd2.sendKeys("4");
        Thread.sleep(1000);
        direcTd2.sendKeys(Keys.ENTER);
        actions.build().perform();
        Thread.sleep(2000);
    }

    @And("Lleno los datos de datos de la cuenta$")
    public void typeDataAccount() throws Throwable {
        Actions actions = new Actions(driver);
        /* Datos de la cuenta */
        /* Ejecutivo */
        WebElement executive = driver.findElement(selctAccData_Executive);
        for(int i= 0; i<10; i++ ) {
            executive.sendKeys(Keys.BACK_SPACE);
        }
        executive.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        executive.sendKeys("BA01000815");
        Thread.sleep(1000);
        executive.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Origen */
        WebElement origin = driver.findElement(selctAccData_Origin);
        origin.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        origin.sendKeys("ROF");
        Thread.sleep(1000);
        origin.sendKeys(Keys.ENTER);
        actions.build().perform();
        Thread.sleep(2000);
    }

    @And("Lleno los datos de datos del certificado$")
    public void typeDataCertificate() throws Throwable {
        Actions actions = new Actions(driver);
        /* Datos del certificado */
        /* Valor */
        WebElement valor = driver.findElement(selctCertData_Value);
        Thread.sleep(2000);
        valor.sendKeys("1,000.00");
        Thread.sleep(1000);
        valor.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Frecuencia */
        WebElement frequency = driver.findElement(selctCertData_Frecuency);
        frequency.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        frequency.sendKeys("0");
        Thread.sleep(1000);
        frequency.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Días Plazo */
        WebElement daysTerm = driver.findElement(selctCertData_DaysTerm);
        Thread.sleep(2000);
        daysTerm.sendKeys("180");
        daysTerm.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Capitalización de interés */
        WebElement capitalization = driver.findElement(btnCertData_CapitalizationInterest);
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", capitalization);
        Thread.sleep(2000);
        /* Taza de Interés */
        WebElement interest = driver.findElement(btnCertData_Interest);
        interest.click();
        Thread.sleep(2000);
        /* Cerrar diálogo */
        WebElement dialog = driver.findElement(btnCertData_DialogClose);
        Thread.sleep(4000);
        dialog.click();
        /* Construcción */
        actions.build().perform();
        Thread.sleep(2000);
    }

    @And("Copio los datos ingresados en titulares en firmas autorizadas$")
    public void copyFirms() throws Throwable {
        Actions actions = new Actions(driver);
        /* Datos del certificado */
        /* Firma1 */
        WebElement firma1 = driver.findElement(btnFirms_FirmTd1);
        firma1.click();
        Thread.sleep(1000);
        /* Firma2 */
        WebElement firma2 = driver.findElement(btnFirms_FirmTd2);
        firma2.click();
        /* Caja Selección */
        WebElement valor = driver.findElement(txtFirms_Firm);
        valor.sendKeys(Keys.ARROW_RIGHT);
        actions.build().perform();
        Thread.sleep(2000);
    }

    @And("Genero el reporte$")
    public void generateReport() throws Throwable {
        Actions actions = new Actions(driver);
        /* Generar reporte */
        WebElement generate = driver.findElement(btnGenRep_Generar);
        generate.click();
        actions.build().perform();
        Thread.sleep(2000);
    }

    @Then("Guardo el formulario$")
    public void saveForm()throws Throwable {
        Actions actions = new Actions(driver);
        /* Barra de Tareas */
        /* Save */
        WebElement save = driver.findElement(btnSave);
        save.click();
        actions.build().perform();
        Thread.sleep(2000);
    }

    @And("Y confirmo la creacion del numero de solicitud$")
    public void checkNumberRequest() throws Throwable {
        String resultText = driver.findElement(messageStatus).getText();
        int cont = 1;
        while (resultText.equals("PROCESANDO...") && cont <= 40) {
            Thread.sleep(1000);
            cont++;
            resultText = driver.findElement(messageStatus).getText();
        }
        if (resultText.equals("PROCESANDO...")) {
            System.out.println("Time Out, Error al validar el formulario, " + resultText);
        } else {
            Actions actions = new Actions(driver);
            WebElement numberRequest = driver.findElement(txtNumberRequest);
            numberRequest.sendKeys(Keys.ARROW_RIGHT);
            String messageNumberRequest = driver.findElement(txtNumberRequest).getAttribute("value");
            System.out.println("Número de Solicitud: " + messageNumberRequest);
            actions.build().perform();
        }
        Thread.sleep(2000);
    }

    @And("Cierro el Browser$")
    public void closeBrowser() throws Throwable {
        Thread.sleep(3000);
        /*driver.close();*/
    }
}
