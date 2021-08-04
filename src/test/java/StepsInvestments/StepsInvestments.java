package StepsInvestments;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class StepsInvestments {
    private WebDriver driver;
    /* Login */
    private By txtUser = By.xpath("//*[@id='ingreso']/input[1]");
    private By txtPassword = By.xpath("//*[@id='ingreso']/input[2]");
    private By btnSubmit = By.xpath("//*[@id='ingreso']/p[2]/input");
    /* Login - more options */
    private By linkMoreOptions = By.id("mas_opciones");
    private By btnForceClose = By.id("cierre");
    /* Formulario Principal */
    private By txtCode = By.id("entorno-pt");
    private By messageStatus = By.id("entorno-estatus-contenido");
    /* Transacción 05-2000 */
    /* DATOS GENERALES */
    /* Número de Solicitud */
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
    private By txtAccData_Executive = By.xpath("//*[@id='c_F3Cusrcta_0']");
    /* Datos del Certificado */
    private By selctCertData_Value = By.xpath("//*[@id='c_f7valor_0']");
    private By arrowSelctCertData_Frecuency = By.xpath("//*[@id='container_5']/table/tbody/tr/td[1]/table/tbody/tr[4]/td[2]/img");
    private By selctCertData_Frecuency = By.xpath("//*[@id='c_f7frecuencia_0']");
    private By selctCertData_DaysTerm = By.xpath("//*[@id='c_f7diasplazo_0']");
    private By btnCertData_Interest = By.xpath("//*[@id='c_F4Tasaboton_0']");
    private By btnCertData_AutomaticRenovation = By.xpath("//*[@id='container_5']/table/tbody/tr/td[3]/table/tbody/tr[1]/td[2]/span/input[2]");
    private By btnCertData_CapitalizationInterest = By.xpath("//*[@id='container_5']/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/span/input[2]");
    private By btnCertData_DialogClose = By.xpath("//*[@id='entorno-formulario']/div[2]/form/div[11]/div[1]/img");
    /* Firmas */
    private By btnFirms_FirmTd1 = By.xpath("//*[@id='c_Btncopiar_0']");
    private By btnFirms_FirmTd2 = By.xpath("//*[@id='c_Btncopiar_1']");
    private By txtFirms_Firm = By.xpath("//*[@id='c_F4Identificacion_2']");
    /* Generar Reporte */
    private By btnGenRep_Generar = By.xpath("//*[@id='container_7']/table/tbody/tr/td/button");
    /* DETALLE SOLICITUD DE FONDOS */
    private By btnDetReq_Main = By.xpath("//*[@id='container_0']/table/tbody/tr/td/ul[1]/li[2]/a");
    private By chkDetReq_Salary = By.xpath("//*[@id='c_F2salario_0']");
    private By chkDetReq_Transfers = By.xpath("//*[@id='c_F2transferencias_0']");
    private By chkDetReq_Herency = By.xpath("//*[@id='c_F2herencia_0']");
    private By arrowModalDetReq_InitialDeposit = By.xpath("//*[@id='container_5']/table/tbody/tr[2]/td/img");
    private By txtAreaDetReq_InitialDeposit = By.xpath("/html/body/div[13]/div[2]/textarea");
    private By btnCloseDetReq_InitialDeposit = By.xpath("/html/body/div[13]/div[1]/img");
    private By selctDetReq_PurposeAccount = By.xpath("//*[@id='c_F4proposito_0']");
    private By arrowModalDetReq_Occupation = By.xpath("//*[@id='container_7']/table/tbody/tr[2]/td/img");
    private By txtAreaDetReq_Occupation = By.xpath("/html/body/div[13]/div[2]/textarea");
    private By btnCloseDetReq_Occupation = By.xpath("/html/body/div[13]/div[1]/img");
    private By arrowModalDetReq_Comment = By.xpath("//*[@id='container_8']/table/tbody/tr[2]/td/img");
    private By txtAreaDetReq_Comment = By.xpath("/html/body/div[13]/div[2]/textarea");
    private By btnCloseDetReq_Comment = By.xpath("/html/body/div[13]/div[1]/img");
    private By chkDetReq_YesOwner = By.xpath("//*[@id='container_9']/table/tbody/tr[2]/td[1]/span[2]/input[2]");
    /* DETALLE INGRESO DE FONDOS */
    private By btnFod_Main = By.xpath("//*[@id='container_0']/table/tbody/tr/td/ul[1]/li[3]/a");
    /* Débito de Cuentas */
    private By btnFodDebAcc_Td1Arrow = By.xpath("//*[@id='container_4']/div/table/tbody/tr[1]/td[4]/img");
    private By txtFodDebAcc_Td1Account = By.xpath("//*[@id='container_4']/div/table/tbody/tr[1]/td[4]/input");
    private By txtFodDebAcc_Td1Value = By.xpath("//*[@id='container_4']/div/table/tbody/tr[1]/td[5]/input");

    /* Opciones de tareas */
    private By btnSave = By.xpath("//*[@id='entorno-teclas']/button[9]");
    /* Generar reporte */
    private By viewStratrace = By.xpath("/html/body/a");
    private By closeWindowReport = By.xpath("/html/body/button[1]");

    @Given("Abre el web browser Chrome y direcciona a la aplicacion$")
    public void openBrowser() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/ue0100066b/Documentos/Chris/TestingCourse/Extraido/Chrome-Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://10.1.115.64:8380/WEB3/ingreso.html");
    }

    @When("Cierro de sesiones activas e engreso el usuario UE0100066B y la contrasena chris012345$")
    public void closeSessionAndTypeUserPassword()throws Throwable {
        /* Forzar cierre de sesiones */
        Thread.sleep(2000);
        driver.findElement(linkMoreOptions).click();
        Thread.sleep(2000);
        driver.findElement(btnForceClose).click();
        Thread.sleep(2000);
        /* Ingreso de usuario y contraseña */
        driver.findElement(txtUser).sendKeys("UE0100066B");
        Thread.sleep(2000);
        driver.findElement(txtPassword).sendKeys("chris012345");
        Thread.sleep(2000);
        driver.findElement(btnSubmit).click();
        Thread.sleep(2000);
    }

    @Then("Visualizo el menu principal$")
    public void viewForm()throws Throwable {
        String resultText = driver.findElement(messageStatus).getText();
        if (resultText.equalsIgnoreCase("OK")) {
            System.out.println("Éxito al cargar el menú principal, " + resultText);
        } else {
            System.out.println("Error al cargar el menú principal, " + resultText);
        }
    }

    @When("Ingreso la transaccion 05-2000$")
    public void typeTransaction() throws Throwable {
        driver.findElement(txtCode).sendKeys("05-2000");
        Thread.sleep(2000);
        driver.findElement(txtCode).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @Then("Visualizo el estado de la transaccion$")
    public void viewStatusForm()throws Throwable {
        int cont = 1;
        String resultText = driver.findElement(messageStatus).getText();
        while (resultText.equalsIgnoreCase("CARGANDO FORMULARIO...") && cont <= 10) {
            Thread.sleep(1000);
            cont++;
            resultText = driver.findElement(messageStatus).getText();
        }
        if (resultText.equalsIgnoreCase("CARGANDO FORMULARIO...")) {
            System.out.println("Time Out, Error al cargar el formulario, " + resultText);
        } else {
            String [] vect = resultText.split(" ");
            if (vect[0].equalsIgnoreCase("NO")) {
                /* Mensaje de que no Existe el Formulario 0000 */
                System.out.println("Error, " + resultText);
            } else if (vect[1].equalsIgnoreCase("CARGADO")) {
                /* Mensaje de éxito de carga de Formulario 0000 */
                System.out.println("Éxito, " + resultText);
            } else {
                /* Diferentes errores de validación */
                System.out.println(resultText);
            }
        }
    }

    @When("Lleno el item de datos generales: titular y cotitulares, datos de la cuenta y datos del certificado$")
    public void typeGeneralData() throws Throwable {
        /* ---- DATOS GENERALES ---- */
        /* Titular y Cotitulares */
        /* Titutar */
        /* TD1 */
        /* Identificación */
        driver.findElement(selctTitCotiTd1_Identificacion).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(selctTitCotiTd1_Identificacion).sendKeys("1704556644");
        Thread.sleep(1000);
        driver.findElement(selctTitCotiTd1_Identificacion).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Dirección */
        driver.findElement(selctTitCotiTd1_Direccion).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(selctTitCotiTd1_Direccion).sendKeys("1");
        Thread.sleep(1000);
        driver.findElement(selctTitCotiTd1_Direccion).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Cotitutar */
        /* TD2 */
        /* Y/O */
        driver.findElement(selctTitCotiTd2_YO).sendKeys("Y");
        Thread.sleep(2000);
        /* Identificación */
        driver.findElement(selctTitCotiTd2_Identificacion).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(selctTitCotiTd2_Identificacion).sendKeys("1100039401");
        Thread.sleep(1000);
        driver.findElement(selctTitCotiTd2_Identificacion).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Relación */
        driver.findElement(selctTitCotiTd2_Relacion).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(selctTitCotiTd2_Relacion).sendKeys("CTI");
        Thread.sleep(1000);
        driver.findElement(selctTitCotiTd2_Relacion).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Dirección */
        driver.findElement(selctTitCotiTd2_Direccion).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(selctTitCotiTd2_Direccion).sendKeys("4");
        Thread.sleep(1000);
        driver.findElement(selctTitCotiTd2_Direccion).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* ---- DATOS DE LA CUENTA ---- */
        /* Ejecutivo */
        String executiveGetValue = driver.findElement(txtAccData_Executive).getAttribute("value");
        for (int i = 0; i < executiveGetValue.length(); i++) {
            driver.findElement(selctAccData_Executive).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(selctAccData_Executive).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(selctAccData_Executive).sendKeys("BA01000815");
        Thread.sleep(1000);
        driver.findElement(selctAccData_Executive).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Origen */
        driver.findElement(selctAccData_Origin).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(selctAccData_Origin).sendKeys("ROF");
        Thread.sleep(1000);
        driver.findElement(selctAccData_Origin).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* ---- DATOS DEL CERTIFICADO ---- */
        /* Valor */
        driver.findElement(selctCertData_Value).sendKeys("1,000.00");
        Thread.sleep(2000);
        driver.findElement(selctCertData_Value).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Frecuencia */
        driver.findElement(arrowSelctCertData_Frecuency).click();
        Thread.sleep(2000);
        driver.findElement(selctCertData_Frecuency).sendKeys("0");
        Thread.sleep(1000);
        driver.findElement(selctCertData_Frecuency).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Días Plazo */
        driver.findElement(selctCertData_DaysTerm).sendKeys("180");
        Thread.sleep(2500);
        driver.findElement(selctCertData_DaysTerm).sendKeys(Keys.ENTER);
        /* Para Testing con el check en intereses se activa */
        /*driver.findElement(btnCertData_AutomaticRenovation).click();
        Thread.sleep(2000);*/
        Thread.sleep(2000);
    }

    @And("Detallo renovacion automatica en true y capitalizacion de intereses en true$")
    public void typeCheckInteres1() throws Throwable {
        WebElement automaticRenovation = driver.findElement(btnCertData_AutomaticRenovation);
        if (automaticRenovation.isSelected()) {
            driver.findElement(btnCertData_CapitalizationInterest).click();
            System.out.println("Check Interés: Ambos en true");
        } else {
            driver.findElement(btnCertData_AutomaticRenovation).click();
            driver.findElement(btnCertData_CapitalizationInterest).click();
            System.out.println("Check Interés: Estaba desactivado el automático, ahora ambos en true");
        }
        Thread.sleep(2000);
    }

    @And("Detallo renovacion automatica en true y capitalizacion de intereses en false$")
    public void typeCheckInteres2() throws Throwable {
        WebElement automaticRenovation = driver.findElement(btnCertData_AutomaticRenovation);
        if(!automaticRenovation.isSelected()) {
            driver.findElement(btnCertData_AutomaticRenovation).click();
            System.out.println("Check Interés: Estaba desactivado el automático, ahora es true y false");
        } else {
            System.out.println("Check Interés: Default");
        }
        Thread.sleep(2000);
    }

    @And("Lleno el item de datos generales: datos del certificado y firmas$")
    public void typeInterestAndFirms() throws Throwable {
        /* Taza de Interés */
        driver.findElement(btnCertData_Interest).click();
        Thread.sleep(4000);
        /* Cerrar diálogo */
        driver.findElement(btnCertData_DialogClose).click();
        Thread.sleep(2000);
        /* ---- FIRMAS AUTORIZADAS DEL DEPOSITO ---- */
        /* Firma1 */
        driver.findElement(btnFirms_FirmTd1).click();
        Thread.sleep(2000);
        /* Firma2 */
        driver.findElement(btnFirms_FirmTd2).click();
        Thread.sleep(2000);
        /* Caja Selección */
        driver.findElement(txtFirms_Firm).sendKeys(Keys.ARROW_RIGHT);
        Thread.sleep(2000);
    }

    @And("Genero el reporte$")
    public void generateReport() throws Throwable {
        /* Generar reporte */
        driver.findElement(btnGenRep_Generar).click();
        /* Todas las ventanas abiertas en prueba*/
        Set<String> windows = driver.getWindowHandles();
        /* Ventana principal */
        String mainWindow = driver.getWindowHandle();
        for (String handle: windows) {
            driver.switchTo().window(handle);
            String pagetitle = driver.getTitle();
            int cont = 1;
            /* Control de la página de Error */
            while (pagetitle.equals("") && cont <= 120)  {
                Thread.sleep(1000);
                cont++;
                pagetitle = driver.getTitle();
            }
            System.out.println("Página: " + pagetitle);
            if(pagetitle.equalsIgnoreCase("Error")) {
                Thread.sleep(1000);
                driver.findElement(viewStratrace).click();
                Thread.sleep(2000);
                WebElement closeWindow = driver.findElement(closeWindowReport);
                Thread.sleep(2000);
                closeWindow.click();
            } else if (pagetitle.equalsIgnoreCase("")) {
                System.out.println("Time out, páginas no cargadas.");
            }
        }
        driver.switchTo().window(mainWindow);
        Thread.sleep(2000);
    }

    @Then("Guardo el formulario$")
    public void saveForm()throws Throwable {
        /* Barra de Tareas */
        /* Save */
        driver.findElement(btnSave).click();
        Thread.sleep(2000);
    }

    @And("Confirmo la creacion del numero de solicitud$")
    public void checkNumberRequest() throws Throwable {
        String resultText = driver.findElement(messageStatus).getText();
        int cont = 1;
        /* Control de carga al procesar la transacción con Datos Generales */
        while (resultText.equalsIgnoreCase("PROCESANDO...") && cont <= 120) {
            Thread.sleep(1000);
            cont++;
            resultText = driver.findElement(messageStatus).getText();
        }
        if (resultText.equalsIgnoreCase("PROCESANDO...")) {
            System.out.println("Time Out, Error al validar el formulario, " + resultText);
        } else if (resultText.equalsIgnoreCase("TRANSACCION REALIZADA CORRECTAMENTE")) {
            driver.findElement(txtNumberRequest).sendKeys(Keys.ARROW_RIGHT);
            String messageNumberRequest = driver.findElement(txtNumberRequest).getAttribute("value");
            System.out.println("Número de Solicitud: " + messageNumberRequest);
        } else {
            System.out.println(resultText);
        }
        Thread.sleep(2000);
    }

    @When("LLeno el formulario de detalle de la solicitud de fondos$")
    public void typeFormDetailRequest() throws Throwable {
        driver.findElement(btnDetReq_Main).click();
        Thread.sleep(2000);
        /* ChecBox de Origen de los Fondos*/
        driver.findElement(chkDetReq_Salary).click();
        Thread.sleep(2000);
        driver.findElement(chkDetReq_Transfers).click();
        Thread.sleep(2000);
        driver.findElement(chkDetReq_Herency).click();
        Thread.sleep(2000);
        /* Procedencia De Fondos Del Depósito Inicial */
        driver.findElement(arrowModalDetReq_InitialDeposit).click();
        Thread.sleep(2000);
        driver.findElement(txtAreaDetReq_InitialDeposit).sendKeys("ARRENDAMIENTO DE BIENES");
        Thread.sleep(2000);
        driver.findElement(btnCloseDetReq_InitialDeposit).click();
        Thread.sleep(2000);
        /* Propósito de la Cuenta */
        driver.findElement(selctDetReq_PurposeAccount).click();
        Thread.sleep(1000);
        driver.findElement(selctDetReq_PurposeAccount).sendKeys("ADQUIRIR BIENES A FUTURO");
        Thread.sleep(2000);
        driver.findElement(selctDetReq_PurposeAccount).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        /* Ocupación */
        driver.findElement(arrowModalDetReq_Occupation).click();
        Thread.sleep(2000);
        driver.findElement(txtAreaDetReq_Comment).sendKeys("SOFTWARE DEVELOPER");
        Thread.sleep(2000);
        driver.findElement(btnCloseDetReq_Occupation).click();
        Thread.sleep(2000);
        /* Comentario */
        driver.findElement(arrowModalDetReq_Comment).click();
        Thread.sleep(2000);
        driver.findElement(txtAreaDetReq_Occupation).sendKeys("TEST COMMENT");
        Thread.sleep(2000);
        driver.findElement(btnCloseDetReq_Comment).click();
        Thread.sleep(2000);
        WebElement selectYesOwner = driver.findElement(chkDetReq_YesOwner);
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", selectYesOwner);
        Thread.sleep(2000);
    }

    @And("Valido el formulario de detalle de la solicitud de fondos$")
    public void validateDetailRequest() throws Throwable {
        String resultText = driver.findElement(messageStatus).getText();
        int cont = 1;
        /* Control de carga al procesar la transacción con Datos Generales */
        while (resultText.equalsIgnoreCase("PROCESANDO...") && cont <= 120) {
            Thread.sleep(1000);
            cont++;
            resultText = driver.findElement(messageStatus).getText();
        }
        if (resultText.equalsIgnoreCase("PROCESANDO...")) {
            System.out.println("Time Out, Error al validar el formulario, " + resultText);
        } else if (resultText.equalsIgnoreCase("TRANSACCION REALIZADA CORRECTAMENTE")){
            System.out.println("Éxito, detalle de solicitud: " +  resultText);
        } else {
            System.out.println(resultText);
        }
        Thread.sleep(2000);
    }

    @When("LLeno el formulario de detalle de ingreso de fondos$")
    public void typeGetFounds() throws Throwable {
        driver.findElement(btnFod_Main).click();
        Thread.sleep(2000);
        driver.findElement(btnFodDebAcc_Td1Arrow).click();
        Thread.sleep(2000);
        driver.findElement(txtFodDebAcc_Td1Account).sendKeys("1100237829");
        Thread.sleep(1000);
        driver.findElement(txtFodDebAcc_Td1Account).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(txtFodDebAcc_Td1Value).sendKeys("1000");
        Thread.sleep(2000);
        driver.findElement(txtFodDebAcc_Td1Value).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @And("Valido el formulario de detalle de ingreso de fondos$")
    public void typeFounds() throws Throwable {
        String resultText = driver.findElement(messageStatus).getText();
        int cont = 1;
        /* Control de carga al procesar la transacción con Datos Generales */
        while (resultText.equalsIgnoreCase("PROCESANDO...") && cont <= 120) {
            Thread.sleep(1000);
            cont++;
            resultText = driver.findElement(messageStatus).getText();
        }
        if (resultText.equalsIgnoreCase("PROCESANDO...")) {
            System.out.println("Time Out, Error al validar el formulario, " + resultText);
        } else if (resultText.equalsIgnoreCase("TRANSACCION REALIZADA CORRECTAMENTE")){
            System.out.println("Éxito, detalle de ingreso de fondos: " +  resultText);
        } else {
            System.out.println(resultText);
        }
        Thread.sleep(2000);
    }

    @And("Cierro el Browser$")
    public void closeBrowser() throws Throwable {
        Thread.sleep(3000);
        /*driver.close();*/
    }
}
