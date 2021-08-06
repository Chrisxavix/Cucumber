package StepsInvestments;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

public class StepsInvestments {
    private WebDriver driver;
    /* Login */
    private By txtUser = By.xpath("//*[@id='ingreso']/input[1]");
    private By txtPassword = By.xpath("//*[@id='ingreso']/input[2]");
    private By btnSubmit = By.xpath("//*[@id='ingreso']/p[2]/input");
    private By errorLogin = By.xpath("//*[@id='mensajeError']");
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
    private By txtFodChkCash_Cash = By.xpath("//*[@id='container_5']/table/tbody/tr[1]/td[2]/input[1]");
    private By txtFodChkCash_Check = By.xpath("//*[@id='container_5']/table/tbody/tr[2]/td[2]/input[1]");
    /* PAGOS */
    private By btnPayt_Main = By.xpath("//*[@id='container_0']/table/tbody/tr/td/ul[1]/li[4]/a");
    /* TABLA DE PAGOS */
    private By btnTablePayt_Main = By.xpath("//*[@id='container_0']/table/tbody/tr/td/ul[1]/li[5]/a");
    /* IMPRESION DE DOCUMENTOS */
    private By btnPrtDoc_Main = By.xpath("//*[@id='container_0']/table/tbody/tr/td/ul[1]/li[6]/a");
    private By txtPrtDoc_C1F1 = By.xpath("//*[@id='container_3']/div/table/tbody/tr[1]/td[1]/input");
    private By txtPrtDoc_C1F2 = By.xpath("//*[@id='container_3']/div/table/tbody/tr[2]/td[1]/input");
    private By txtPrtDoc_C1F3 = By.xpath("//*[@id='container_3']/div/table/tbody/tr[3]/td[1]/input");
    private By txtPrtDoc_C1F4 = By.xpath("//*[@id='container_3']/div/table/tbody/tr[4]/td[1]/input");
    private By btnPrtDoc_C3F1 = By.xpath("//*[@id='container_3']/div/table/tbody/tr[1]/td[3]/button");
    private By btnPrtDoc_C3F2 = By.xpath("//*[@id='container_3']/div/table/tbody/tr[2]/td[3]/button");
    private By btnPrtDoc_C3F3 = By.xpath("//*[@id='container_3']/div/table/tbody/tr[3]/td[3]/button");
    private By btnPrtDoc_C3F4 = By.xpath("//*[@id='container_3']/div/table/tbody/tr[4]/td[3]/button");
    /* Opciones de tareas */
    private By btnSave = By.xpath("//*[@id='entorno-teclas']/button[9]");
    /* Generar reporte */
    private By viewStratrace = By.xpath("/html/body/a");
    private By closeWindowReport = By.xpath("/html/body/button[1]");
    /* Times */
    int timeOption1 = 1500;

    @Given("Abre el web browser Chrome y direcciona a la aplicacion$")
    public void openBrowser() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/ue0100066b/Documentos/Chris/TestingCourse/Extraido/Chrome-Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://10.1.115.64:8380/WEB3/ingreso.html");
    }

    @When("Cierro sesiones activas e ingreso el usuario UE0100066B y la contrasena chris012345$")
    public void closeSessionAndTypeUserPassword() throws Throwable {
        /* Forzar cierre de sesiones */
        Thread.sleep(timeOption1);
        driver.findElement(linkMoreOptions).click();
        Thread.sleep(timeOption1);
        driver.findElement(btnForceClose).click();
        Thread.sleep(timeOption1);
        /* Ingreso de usuario y contraseña */
        driver.findElement(txtUser).sendKeys("UE0100066B");
        Thread.sleep(timeOption1);
        driver.findElement(txtPassword).sendKeys("chris012345");
        Thread.sleep(timeOption1);
        driver.findElement(btnSubmit).click();
        Thread.sleep(timeOption1);
    }

    @Then("Valido las credenciales del Login$")
    public void validateLogin() throws Throwable {
        String pageNavigateTitle = driver.getTitle();
        if (pageNavigateTitle.equalsIgnoreCase("Mensaje")) {
            String txtMessage = driver.findElement(errorLogin).getText();
            System.out.println("ERROR DE LOGIN " + txtMessage);
            driver.close();
        } else {
            System.out.println("EXITO. LOGIN COMPLETADO");
        }
    }

    @Then("Valido el estado de la transaccion$")
    public void viewStatusForm() throws Throwable {
        int cont = 1;
        String resultStatus = driver.findElement(messageStatus).getText();
        String pageNavigateTitle = driver.getTitle();
        String txtTransaction = driver.findElement(txtCode).getAttribute("value");
        String successTransaction = "TRANSACCION REALIZADA CORRECTAMENTE";
        while (resultStatus.equalsIgnoreCase("CARGANDO FORMULARIO...")
               || resultStatus.equalsIgnoreCase("PROCESANDO...") && cont <= 10) {
            Thread.sleep(1000);
            cont++;
            resultStatus = driver.findElement(messageStatus).getText();
        }
        /* Para testear lo que recibo */
        /*System.out.println("resultStatus: " + resultStatus);
        System.out.println("txtTransaction: " + txtTransaction);*/
        if (resultStatus.equalsIgnoreCase("CARGANDO FORMULARIO...")) {
            System.out.println("TIME OUT. ERROR AL CARGAR EL FORMULARIO: " + pageNavigateTitle.toUpperCase() + ". ESTADO: " + resultStatus.toUpperCase());
            driver.close();
        } else if (resultStatus.equalsIgnoreCase(successTransaction) && txtTransaction.equals("05-2000")) {
            driver.findElement(txtNumberRequest).sendKeys(Keys.ARROW_RIGHT);
            String messageNumberRequest = driver.findElement(txtNumberRequest).getAttribute("value");
            System.out.println("EXITO. TRANSACCION " + txtTransaction + ". DATOS GENERALES. NUMERO DE SOLICITUD: " + messageNumberRequest + ". ESTADO: " + resultStatus);
        } else if (resultStatus.equalsIgnoreCase(successTransaction) && txtTransaction.equals("05-2004")) {
            System.out.println("EXITO. TRANSACCION " + txtTransaction + ". DETALLE SOCICITUD DE FONDOS. ESTADO: " + resultStatus);
        } else if (resultStatus.equalsIgnoreCase(successTransaction) && txtTransaction.equals("05-2002")) {
            System.out.println("EXITO. TRANSACCION " + txtTransaction + ". DETALLE INGRESO DE FONDOS. ESTADO: " + resultStatus);
        } else if (resultStatus.equalsIgnoreCase(successTransaction) && txtTransaction.equals("05-2003")) {
            System.out.println("EXITO. TRANSACCION " + txtTransaction + ". PAGOS. ESTADO: "+ resultStatus);
        } else if (resultStatus.equalsIgnoreCase(successTransaction) && txtTransaction.equals("05-4012")) {
            System.out.println("EXITO. TRANSACCION " + txtTransaction + ". TABLA DE PAGOS. ESTADO: " + resultStatus);
        } else if (resultStatus.equalsIgnoreCase("OK") && txtTransaction.equals("05-3064")) {
            System.out.println("EXITO. TRANSACCION " + txtTransaction + ". IMPRESION DE DOCUMENTOS. ESTADO: " + resultStatus);
        } else if (resultStatus.equalsIgnoreCase(successTransaction) && txtTransaction.equals("05-4000")) {
            System.out.println("EXITO. TRANSACCION " + txtTransaction + ". CONSULTA DE SOLICITUDES POR AUTORIZAR. ESTADO: " + resultStatus);
        } else if (resultStatus.equalsIgnoreCase("OK")
                || resultStatus.equalsIgnoreCase("FORMULARIO CARGADO CORRECTAMENTE")) {
            System.out.println("EXITO. PAGINA: " + pageNavigateTitle.toUpperCase() + ". ESTADO: " + resultStatus);
        } else {
            System.out.println("ERROR. " + pageNavigateTitle.toUpperCase() + ". ESTADO: " + resultStatus);
            driver.close();
        }
        Thread.sleep(timeOption1);
    }

    @When("Ingreso la transaccion 05-2000$")
    public void typeTransaction() throws Throwable {
        driver.findElement(txtCode).sendKeys("05-2000");
        Thread.sleep(timeOption1);
        driver.findElement(txtCode).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
    }

    @When("Ingreso informacion en el item de datos generales: titular y cotitulares, datos de la cuenta y datos del certificado$")
    public void typeGeneralData() throws Throwable {
        /* ---- DATOS GENERALES ---- */
        /* Titular y Cotitulares */
        /* Titutar */
        /* TD1 */
        /* Identificación */
        driver.findElement(selctTitCotiTd1_Identificacion).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(timeOption1);
        driver.findElement(selctTitCotiTd1_Identificacion).sendKeys("1704556644");
        Thread.sleep(timeOption1);
        driver.findElement(selctTitCotiTd1_Identificacion).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        /* Dirección */
        driver.findElement(selctTitCotiTd1_Direccion).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(timeOption1);
        driver.findElement(selctTitCotiTd1_Direccion).sendKeys("1");
        Thread.sleep(timeOption1);
        driver.findElement(selctTitCotiTd1_Direccion).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        /* Cotitutar */
        /* TD2 */
        /* Y/O */
        driver.findElement(selctTitCotiTd2_YO).sendKeys("Y");
        Thread.sleep(timeOption1);
        /* Identificación */
        driver.findElement(selctTitCotiTd2_Identificacion).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(timeOption1);
        driver.findElement(selctTitCotiTd2_Identificacion).sendKeys("1100039401");
        Thread.sleep(timeOption1);
        driver.findElement(selctTitCotiTd2_Identificacion).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        /* Relación */
        driver.findElement(selctTitCotiTd2_Relacion).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(timeOption1);
        driver.findElement(selctTitCotiTd2_Relacion).sendKeys("CTI");
        Thread.sleep(timeOption1);
        driver.findElement(selctTitCotiTd2_Relacion).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        /* Dirección */
        driver.findElement(selctTitCotiTd2_Direccion).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(timeOption1);
        driver.findElement(selctTitCotiTd2_Direccion).sendKeys("4");
        Thread.sleep(timeOption1);
        driver.findElement(selctTitCotiTd2_Direccion).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        /* ---- DATOS DE LA CUENTA ---- */
        /* Ejecutivo */
        String executiveGetValue = driver.findElement(txtAccData_Executive).getAttribute("value");
        for (int i = 0; i < executiveGetValue.length(); i++) {
            driver.findElement(selctAccData_Executive).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(selctAccData_Executive).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(timeOption1);
        driver.findElement(selctAccData_Executive).sendKeys("BA01000815");
        Thread.sleep(timeOption1);
        driver.findElement(selctAccData_Executive).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        /* Origen */
        driver.findElement(selctAccData_Origin).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(timeOption1);
        driver.findElement(selctAccData_Origin).sendKeys("ROF");
        Thread.sleep(timeOption1);
        driver.findElement(selctAccData_Origin).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        /* ---- DATOS DEL CERTIFICADO ---- */
        /* Valor */
        driver.findElement(selctCertData_Value).sendKeys("1,000.00");
        Thread.sleep(timeOption1);
        driver.findElement(selctCertData_Value).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        /* Frecuencia */
        driver.findElement(arrowSelctCertData_Frecuency).click();
        Thread.sleep(timeOption1);
        driver.findElement(selctCertData_Frecuency).sendKeys("0");
        Thread.sleep(timeOption1);
        driver.findElement(selctCertData_Frecuency).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        /* Días Plazo */
        driver.findElement(selctCertData_DaysTerm).sendKeys("180");
        Thread.sleep(timeOption1);
        driver.findElement(selctCertData_DaysTerm).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        /* Taza de Interés - Abre el diálogo */
        driver.findElement(btnCertData_Interest).click();
        Thread.sleep(4000);
        /* Cerrar diálogo */
        driver.findElement(btnCertData_DialogClose).click();
        /* Para Testing con el check en intereses se desactive */
        /*driver.findElement(btnCertData_AutomaticRenovation).click();
        Thread.sleep(timeOption1);*/
        Thread.sleep(timeOption1);
    }

    @And("Selecciono la renovacion automatica en true y capitalizacion de intereses en true$")
    public void typeCheckInteres1() throws Throwable {
        WebElement automaticRenovation = driver.findElement(btnCertData_AutomaticRenovation);
        if (automaticRenovation.isSelected()) {
            driver.findElement(btnCertData_CapitalizationInterest).click();
            System.out.println("EXITO. CHECK INTERES - AMBOS EN TRUE");
        } else {
            driver.findElement(btnCertData_AutomaticRenovation).click();
            driver.findElement(btnCertData_CapitalizationInterest).click();
            System.out.println("EXITO. CHECK INTERES - ESTABA DESACTIVADO EL AUTOMATICO, AHORA AMBOS EN TRUE");
        }
        Thread.sleep(timeOption1);
    }

    @And("Selecciono la renovacion automatica en true y capitalizacion de intereses en false$")
    public void typeCheckInteres2() throws Throwable {
        WebElement automaticRenovation = driver.findElement(btnCertData_AutomaticRenovation);
        if (!automaticRenovation.isSelected()) {
            driver.findElement(btnCertData_AutomaticRenovation).click();
            System.out.println("EXITO. CHECK INTERES - ESTABA DESACTIVADO EL AUTOMATICO, AHORA ES TRUE Y FALSE");
        } else {
            System.out.println("EXITO. CHECK INTERES - DEFAULT");
        }
        Thread.sleep(timeOption1);
    }

    @And("Ingreso informacion en el item de datos generales: firmas$")
    public void copyFirms() throws Throwable {
        /* ---- FIRMAS AUTORIZADAS DEL DEPOSITO ---- */
        /* Firma1 */
        driver.findElement(btnFirms_FirmTd1).click();
        Thread.sleep(timeOption1);
        /* Firma2 */
        driver.findElement(btnFirms_FirmTd2).click();
        Thread.sleep(timeOption1);
        /* Caja Selección */
        driver.findElement(txtFirms_Firm).sendKeys(Keys.ARROW_RIGHT);
        Thread.sleep(timeOption1);
    }

    @And("Genero el reporte$")
    public void generateReport() throws Throwable {
        /* Generar reporte */
        driver.findElement(btnGenRep_Generar).click();
        this.switchPages();
    }

    @And("Guardo el formulario$")
    public void saveForm() throws Throwable {
        /* Barra de Tareas */
        /* Save Form */
        driver.findElement(btnSave).click();
        Thread.sleep(timeOption1);
    }

    @When("Selecciono la pestana de detalle de la solicitud de fondos$")
    public void selectFormDetailRequest() throws Throwable {
        driver.findElement(btnDetReq_Main).click();
        Thread.sleep(timeOption1);
    }

    @When("Ingreso informacion en el formulario de detalle de la solicitud de fondos$")
    public void typeFormDetailRequest() throws Throwable {
        /* ChecBox de Origen de los Fondos */
        driver.findElement(chkDetReq_Salary).click();
        Thread.sleep(timeOption1);
        driver.findElement(chkDetReq_Transfers).click();
        Thread.sleep(timeOption1);
        driver.findElement(chkDetReq_Herency).click();
        Thread.sleep(timeOption1);
        /* Procedencia De Fondos Del Depósito Inicial */
        driver.findElement(arrowModalDetReq_InitialDeposit).click();
        Thread.sleep(timeOption1);
        driver.findElement(txtAreaDetReq_InitialDeposit).sendKeys("ARRENDAMIENTO DE BIENES");
        Thread.sleep(timeOption1);
        driver.findElement(btnCloseDetReq_InitialDeposit).click();
        Thread.sleep(timeOption1);
        /* Propósito de la Cuenta */
        driver.findElement(selctDetReq_PurposeAccount).click();
        Thread.sleep(1000);
        driver.findElement(selctDetReq_PurposeAccount).sendKeys("ADQUIRIR BIENES A FUTURO");
        Thread.sleep(timeOption1);
        driver.findElement(selctDetReq_PurposeAccount).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        /* Ocupación */
        driver.findElement(arrowModalDetReq_Occupation).click();
        Thread.sleep(timeOption1);
        driver.findElement(txtAreaDetReq_Comment).sendKeys("SOFTWARE DEVELOPER");
        Thread.sleep(timeOption1);
        driver.findElement(btnCloseDetReq_Occupation).click();
        Thread.sleep(timeOption1);
        /* Comentario */
        driver.findElement(arrowModalDetReq_Comment).click();
        Thread.sleep(timeOption1);
        driver.findElement(txtAreaDetReq_Occupation).sendKeys("TEST COMMENT");
        Thread.sleep(timeOption1);
        driver.findElement(btnCloseDetReq_Comment).click();
        Thread.sleep(timeOption1);
        driver.findElement(chkDetReq_YesOwner).click();
        Thread.sleep(timeOption1);
    }

    @When("Selecciono la pestana de detalle de ingreso de fondos$")
    public void selectFormTypeFoundst() throws Throwable {
        driver.findElement(btnFod_Main).click();
        Thread.sleep(timeOption1);
    }

    @When("Ingreso informacion en el formulario de detalle de ingreso de fondos$")
    public void typeGetFounds() throws Throwable {
        driver.findElement(btnFodDebAcc_Td1Arrow).click();
        Thread.sleep(timeOption1);
        driver.findElement(txtFodDebAcc_Td1Account).sendKeys("1100237829");
        Thread.sleep(1000);
        driver.findElement(txtFodDebAcc_Td1Account).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        driver.findElement(txtFodDebAcc_Td1Value).sendKeys("500");
        Thread.sleep(timeOption1);
        driver.findElement(txtFodDebAcc_Td1Value).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        driver.findElement(txtFodChkCash_Cash).sendKeys("250");
        Thread.sleep(timeOption1);
        driver.findElement(txtFodDebAcc_Td1Value).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
        driver.findElement(txtFodChkCash_Check).sendKeys("250");
        Thread.sleep(timeOption1);
        driver.findElement(txtFodDebAcc_Td1Value).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
    }

    @When("Selecciono la pestana de pagos$")
    public void selectPayment() throws Throwable {
        driver.findElement(btnPayt_Main).click();
        Thread.sleep(timeOption1);
    }

    @When("Selecciono la pestana de tabla de pagos$")
    public void selectPaymentTable() throws Throwable {
        driver.findElement(btnTablePayt_Main).click();
        Thread.sleep(timeOption1);
    }

    @When("Selecciono la pestana de impresion de documentos$")
    public void viewPrintDocuments() throws Throwable {
        driver.findElement(btnPrtDoc_Main).click();
        Thread.sleep(timeOption1);
    }

    @And("Imprimo los documentos$")
    public void printDocuments() throws Throwable {
        String printC1F1 = driver.findElement(txtPrtDoc_C1F1).getAttribute("value");
        String printC1F2 = driver.findElement(txtPrtDoc_C1F2).getAttribute("value");
        String printC1F3 = driver.findElement(txtPrtDoc_C1F3).getAttribute("value");
        String printC1F4 = driver.findElement(txtPrtDoc_C1F4).getAttribute("value");
        if (printC1F1.length() > 0) {
            driver.findElement(btnPrtDoc_C3F1).click();
            this.switchPages();
        }
        if (printC1F2.length() > 0) {
            driver.findElement(btnPrtDoc_C3F2).click();
            this.switchPages();
        }
        if (printC1F3.length() > 0) {
            driver.findElement(btnPrtDoc_C3F3).click();
            this.switchPages();
        }
        if (printC1F4.length() > 0) {
            driver.findElement(btnPrtDoc_C3F4).click();
            this.switchPages();
        }
    }

    @When("Abro una ventana nueva y redirigir a la transaccion 05-4000$")
    public void openNewWindow() throws Throwable {
        Thread.sleep(3000);
        String mainWindow = driver.getWindowHandle();
        /* Abre una pestaña */
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://10.1.115.64:8380/WEB3/entorno.html");
        this.switchPages();
        driver.findElement(txtCode).sendKeys("05-4000");
        Thread.sleep(timeOption1);
        driver.findElement(txtCode).sendKeys(Keys.ENTER);
        Thread.sleep(timeOption1);
    }

    @And("Cierro el Browser$")
    public void closeBrowser() throws Throwable {
        Thread.sleep(3000);
        /*driver.close();*/
    }

    /* Cambio de páginas al generar reporte */
    public void switchPages() {
        try {
            /* Todas las ventanas abiertas en prueba */
            Set<String> windows = driver.getWindowHandles();
            /* Ventana principal */
            String mainWindow = driver.getWindowHandle();
            for (String handle : windows) {
                driver.switchTo().window(handle);
                String pagetitle = driver.getTitle();
                int cont = 1;
                /* Control de la página de Error */
                while (pagetitle.equals("") && cont <= 120) {
                    Thread.sleep(1000);
                    cont++;
                    pagetitle = driver.getTitle();
                }
                /*System.out.println("Página: " + pagetitle);*/
                if (pagetitle.equalsIgnoreCase("Error")) {
                    Thread.sleep(1000);
                    driver.findElement(viewStratrace).click();
                    Thread.sleep(timeOption1);
                    driver.findElement(closeWindowReport).click();
                    driver.switchTo().window(mainWindow);
                } else if (pagetitle.equalsIgnoreCase("Entorno FitBank")) {
                    System.out.println("EXITO. VENTANA NUEVA: " + pagetitle.toUpperCase());
                } else if (pagetitle.equalsIgnoreCase("")) {
                    System.out.println("TIME OUT. PAGINAS NO CARGADAS");
                    driver.switchTo().window(mainWindow);
                }
            }
            Thread.sleep(timeOption1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
