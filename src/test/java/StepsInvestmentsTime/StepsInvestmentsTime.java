package StepsInvestmentsTime;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.support.ui.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class StepsInvestmentsTime {

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
    private By selctAccData_Origin = By.xpath("//*[@id='c_F3CpropositoCDPC_0']");
    private By txtAccData_Executive = By.xpath("//*[@id='c_F3Cusrcta_0']");
    /* Datos del Certificado */
    private By selctCertData_Value = By.xpath("//*[@id='c_f7valor_0']");
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
    private By txtDetReq_Deposit = By.xpath("//*[@id='container_5']/table/tbody/tr[2]/td/input[1]");
    private By txtDetReq_Occupation = By.xpath("//*[@id='container_7']/table/tbody/tr[2]/td/input[1]");
    private By txtDetReq_Comment = By.xpath("//*[@id='container_8']/table/tbody/tr[2]/td/input[1]");
    private By selctDetReq_PurposeAccount = By.xpath("//*[@id='c_F4proposito_0']");
    private By chkDetReq_YesOwner = By.xpath("//*[@id='container_9']/table/tbody/tr[2]/td[1]/span[2]/input[2]");
    /* DETALLE INGRESO DE FONDOS */
    private By btnFod_Main = By.xpath("//*[@id='container_0']/table/tbody/tr/td/ul[1]/li[3]/a");
    /* Débito de Cuentas */
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
    private By tableSizePrtDoc = By.xpath("//*[@id='container_3']/div/table/tbody/tr");
    private String txtPrtDoc_C1Part1 = "//*[@id='container_3']/div/table/tbody/tr[";
    private String txtPrtDoc_C1Part2 = "]/td[1]/input";
    private String txtPrtDoc_C3Part1 = "//*[@id='container_3']/div/table/tbody/tr[";
    private String txtPrtDoc_C3Part2 = "]/td[3]/button";
    /* Opciones de tareas */
    private By btnSave = By.xpath("//*[@id='entorno-teclas']/button[9]");
    /* Generar reporte */
    private By viewStrace = By.xpath("/html/body/a");
    private By closeWindowReport = By.xpath("/html/body/button[1]");
    /* Times */
    int timeOption1 = 1500;

    @Given("Abre el web browser Chrome y direcciona a la aplicacion$")
    public void openBrowser() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/ue0100066b/Documentos/Chris/TestingCourse/Extraido/Chrome-Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(80, SECONDS);
        driver.get("http://10.1.115.64:8380/WEB3/ingreso.html");
    }

    @When("Cierro sesiones activas, ingreso el usuario UE0100066B y la contrasena chris012345$")
    public void closeSessionAndTypeUserPassword() throws Throwable {
        /* Forzar cierre de sesiones */
        WebElement moreOptions = driver.findElement(linkMoreOptions);
        moreOptions.click();
        WebElement forceClose = driver.findElement(btnForceClose);
        forceClose.click();
        /* Ingreso de usuario y contraseña */
        WebElement user = driver.findElement(txtUser);
        user.sendKeys("UE0100066B");
        WebElement password = driver.findElement(txtPassword);
        password.sendKeys("chris012345");
        WebElement submit = driver.findElement(btnSubmit);
        submit.click();
        /* Validación del Login */
        String pageNavigateTitle = driver.getTitle();
        if (pageNavigateTitle.equalsIgnoreCase("Mensaje")) {
            String txtMessage = driver.findElement(errorLogin).getText();
            System.out.println("ERROR DE LOGIN " + txtMessage);
            driver.close();
        } else {
            System.out.println("EXITO. LOGIN COMPLETADO");
        }
    }

    @Then("Ingreso la transaccion 05-2000$")
    public void typeTransaction() throws Throwable {
        WebElement code = driver.findElement(txtCode);
        code.sendKeys("05-2000");
        code.sendKeys(Keys.ENTER);
    }

    @When("Ingreso informacion en el item de datos generales: titular y cotitulares, datos de la cuenta y datos del certificado$")
    public void typeGeneralData() throws Throwable {
        /* ---- DATOS GENERALES ---- */
        /* Titular y Cotitulares */
        /* Titutar */
        /* TD1 */
        /* Identificación */
        WebElement ide1= driver.findElement(selctTitCotiTd1_Identificacion);
        ide1.sendKeys("1704556644");
        this.waitPass();
        ide1.sendKeys(Keys.ENTER);
        /* Dirección */
        WebElement direction = driver.findElement(selctTitCotiTd1_Direccion);
        direction.sendKeys("1");
        this.waitPass();
        direction.sendKeys(Keys.ENTER);
        /* Cotitutar */
        /* TD2 */
        /* Identificación */
        WebElement ide2 = driver.findElement(selctTitCotiTd2_Identificacion);
        ide2.sendKeys("1100039401");
        this.waitPass();
        ide2.sendKeys(Keys.ENTER);
        /* Relación */
        WebElement relation = driver.findElement(selctTitCotiTd2_Relacion);
        relation.sendKeys("CTI");
        this.waitPass();
        relation.sendKeys(Keys.ENTER);
        /* Y/O */
        WebElement yo = driver.findElement(selctTitCotiTd2_YO);
        yo.sendKeys("Y");
        this.waitPass();
        yo.sendKeys(Keys.ENTER);
        /* Dirección */
        WebElement direction2 = driver.findElement(selctTitCotiTd2_Direccion);
        direction2.sendKeys("4");
        this.waitPass();
        direction2.sendKeys(Keys.ENTER);
        /* ---- DATOS DE LA CUENTA ---- */
        /* Ejecutivo */
        WebElement executive = driver.findElement(txtAccData_Executive);
        executive.clear();
        executive.sendKeys("BA01000815");
        this.waitPass();
        executive.sendKeys(Keys.ENTER);
        /* Origen */
        WebElement origin = driver.findElement(selctAccData_Origin);
        origin.sendKeys("ROF");
        this.waitPass();
        origin.sendKeys(Keys.ENTER);
        /* ---- DATOS DEL CERTIFICADO ---- */
        /* Valor */
        WebElement dateValue = driver.findElement(selctCertData_Value);
        dateValue.sendKeys("1,000.00");
        this.waitPass();
        dateValue.sendKeys(Keys.ENTER);
        /* Frecuencia */
        WebElement frecuency = driver.findElement(selctCertData_Frecuency);
        frecuency.sendKeys("0");
        this.waitPass();
        frecuency.sendKeys(Keys.ENTER);
        /* Días Plazo */
        /* Valido nuevamente porque empieza a procesar cambios en datos de la cuenta */
        this.waitPass();
        WebElement daysTerm = driver.findElement(selctCertData_DaysTerm);
        daysTerm.sendKeys("180");
        this.waitPass();
        daysTerm.sendKeys(Keys.ENTER);
        /* Taza de Interés - Abre el diálogo */
        /* Valido la carga de datos al seleccionar los días de plazo */
        this.waitPass();
        WebElement dialog = driver.findElement(btnCertData_Interest);
        dialog.click();
        Thread.sleep(2000);
        /* Cerrar diálogo */
        WebElement closeDialog = driver.findElement(btnCertData_DialogClose);
        closeDialog.click();
        /* Para Testing con el check en intereses desactivado */
        /*driver.findElement(btnCertData_AutomaticRenovation).click(); */
    }

    @And("Selecciono la renovacion automatica en true y capitalizacion de intereses en true en el item de datos generales$")
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
        this.waitPass();
    }

    @And("Selecciono la renovacion automatica en true y capitalizacion de intereses en false en el item de datos generales$")
    public void typeCheckInteres2() throws Throwable {
        WebElement automaticRenovation = driver.findElement(btnCertData_AutomaticRenovation);
        if (!automaticRenovation.isSelected()) {
            driver.findElement(btnCertData_AutomaticRenovation).click();
            System.out.println("EXITO. CHECK INTERES - ESTABA DESACTIVADO EL AUTOMATICO, AHORA ES TRUE Y FALSE");
        } else {
            System.out.println("EXITO. CHECK INTERES - DEFAULT");
        }
        this.waitPass();
    }

    @And("Ingreso informacion en el item de datos generales: firmas$")
    public void copyFirms() throws Throwable {
        /* ---- FIRMAS AUTORIZADAS DEL DEPOSITO ---- */
        /* Firma1 */
        driver.findElement(btnFirms_FirmTd1).click();
        /* Firma2 */
        driver.findElement(btnFirms_FirmTd2).click();
        /* Caja del número de solicitud */
        this.waitPass();
        driver.findElement(txtFirms_Firm).sendKeys(Keys.ARROW_RIGHT);
    }

    @And("Genero el reporte$")
    public void generateReport() throws Throwable {
        /* Generar reporte */
        WebElement generateReport =  driver.findElement(btnGenRep_Generar);
        generateReport.click();
        this.switchPages();
    }

    @Then("Guardo el formulario$")
    public void saveForm() throws Throwable {
        /* Barra de Tareas */
        /* Save Form */
        WebElement saveForm = driver.findElement(btnSave);
        saveForm.click();
    }

    @And("Valido el estado de la transaccion$")
    public void viewStatusTransaction() throws Throwable {
        int cont = 1;
        String resultStatus = driver.findElement(messageStatus).getText();
        String pageNavigateTitle = driver.getTitle();
        String txtTransaction = driver.findElement(txtCode).getAttribute("value");
        String successTransaction = "TRANSACCION REALIZADA CORRECTAMENTE";
        while (resultStatus.equalsIgnoreCase("CARGANDO FORMULARIO...")
                || resultStatus.equalsIgnoreCase("PROCESANDO...")
                || resultStatus.equalsIgnoreCase("POR FAVOR ESPERE A QUE EL PROCESO ACTUAL TERMINE.")
                && cont <= 120) {
            Thread.sleep(1000);
            cont++;
            resultStatus = driver.findElement(messageStatus).getText();
        }
        /* Para testear lo que recibo */
        /*System.out.println("resultStatus: " + resultStatus);
        System.out.println("txtTransaction: " + txtTransaction);*/
        if (resultStatus.equalsIgnoreCase("CARGANDO FORMULARIO...")
                || resultStatus.equalsIgnoreCase("PROCESANDO...")
                || resultStatus.equalsIgnoreCase("POR FAVOR ESPERE A QUE EL PROCESO ACTUAL TERMINE.")) {
            System.out.println("TIME OUT. ERROR AL CARGAR EL FORMULARIO: " + pageNavigateTitle.toUpperCase() + ". ESTADO: " + resultStatus.toUpperCase());
            driver.close();
        } else if (resultStatus.equalsIgnoreCase(successTransaction) && txtTransaction.equals("05-2000")) {
            driver.findElement(txtNumberRequest).sendKeys(Keys.ARROW_RIGHT);
            String messageNumberRequest = driver.findElement(txtNumberRequest).getAttribute("value");
            System.out.println("EXITO. TRANSACCION " + txtTransaction + ". DATOS GENERALES. NUMERO DE SOLICITUD: " + messageNumberRequest + ". ESTADO: " + resultStatus);
        } else if (resultStatus.equalsIgnoreCase(successTransaction) && txtTransaction.equals("05-2004")) {
            System.out.println("EXITO. TRANSACCION " + txtTransaction + ". DETALLE SOCICITUD DE FONDOS. ESTADO: " + resultStatus);
        } else if (resultStatus.equalsIgnoreCase(successTransaction) || resultStatus.equalsIgnoreCase("OK") && txtTransaction.equals("05-2002")) {
            System.out.println("EXITO. TRANSACCION " + txtTransaction + ". DETALLE INGRESO DE FONDOS. ESTADO: " + resultStatus);
        } else if (resultStatus.equalsIgnoreCase("FORMULARIO CARGADO CORRECTAMENTE") && txtTransaction.equals("05-2003")) {
            System.out.println("EXITO. TRANSACCION " + txtTransaction + ". PAGOS. ESTADO: " + resultStatus);
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
            /*driver.close();*/
        }
        Thread.sleep(timeOption1);
    }

    @When("Selecciono la pestana de detalle de la solicitud de fondos$")
    public void selectFormDetailRequest() throws Throwable {
        WebElement btnDetailRequest = driver.findElement(btnDetReq_Main);
        this.waitPass();
        btnDetailRequest.click();
    }

    @And("Ingreso informacion en el formulario de detalle de la solicitud de fondos$")
    public void typeFormDetailRequest() throws Throwable {
        /* ChecBox de Origen de los Fondos */
        WebElement salary = driver.findElement(chkDetReq_Salary);
        WebElement transfer = driver.findElement(chkDetReq_Transfers);
        WebElement herency = driver.findElement(chkDetReq_Herency);
        /* Validación de que encuentre los elementos en el DOM */
        int cont = 1;
        while (!salary.isEnabled() && !transfer.isEnabled() && !herency.isEnabled() && cont < 120) {
            Thread.sleep(1000);
            cont++;
            salary = driver.findElement(chkDetReq_Salary);
            transfer = driver.findElement(chkDetReq_Transfers);
            herency = driver.findElement(chkDetReq_Herency);
        }
        salary.click();
        transfer.click();
        herency.click();
        WebElement deposit = driver.findElement(txtDetReq_Deposit);
        deposit.sendKeys("ARRENDAMIENTO DE BIENES");
        /* Propósito de la Cuenta */
        Select fruits = new Select(driver.findElement(selctDetReq_PurposeAccount));
        fruits.selectByVisibleText("ADQUIRIR BIENES A FUTURO");
        /* o usar: fruits.selectByIndex(2); */
        WebElement occupation = driver.findElement(txtDetReq_Occupation);
        occupation.sendKeys("SOFTWARE DEVELOPER");
        WebElement comment = driver.findElement(txtDetReq_Comment);
        comment.sendKeys("TEST COMMENT");
        /* Dueño O Beneficiario */
        WebElement yesOwner = driver.findElement(chkDetReq_YesOwner);
        yesOwner.click();
    }

    @When("Selecciono la pestana de pagos$")
    public void selectPayment() throws Throwable {
        WebElement btnPayment = driver.findElement(btnPayt_Main);
        this.waitPass();
        btnPayment.click();
    }

    @When("Selecciono la pestana de detalle de ingreso de fondos$")
    public void selectFormTypeFoundst() throws Throwable {
        WebElement btnTypeFounds = driver.findElement(btnFod_Main);
        this.waitPass();
        btnTypeFounds.click();
    }

    @And("Ingreso informacion en el formulario de detalle de ingreso de fondos$")
    public void typeGetFounds() throws Throwable {
        this.waitPass();
        WebElement td1Account =  driver.findElement(txtFodDebAcc_Td1Account);
        td1Account.sendKeys("1100237829");
        td1Account.sendKeys(Keys.ENTER);
        WebElement td1Value = driver.findElement(txtFodDebAcc_Td1Value);
        td1Value.sendKeys("500");
        td1Value.sendKeys(Keys.ENTER);
        WebElement cash = driver.findElement(txtFodChkCash_Cash);
        cash.sendKeys("250");
        cash.sendKeys(Keys.ENTER);
        WebElement check = driver.findElement(txtFodChkCash_Check);
        check.sendKeys("250");
        check.sendKeys(Keys.ENTER);
    }

    @When("Selecciono la pestana de tabla de pagos$")
    public void selectPaymentTable() throws Throwable {
        WebElement btnPayTable = driver.findElement(btnTablePayt_Main);
        this.waitPass();
        btnPayTable.click();
    }

    @When("Selecciono la pestana de impresion de documentos$")
    public void viewPrintDocuments() throws Throwable {
        WebElement btnPrintDoc = driver.findElement(btnPrtDoc_Main);
        this.waitPass();
        btnPrintDoc.click();
    }

    @And("Imprimo los documentos$")
    public void printDocuments() throws Throwable {
        List<WebElement> tablePrint = driver.findElements(tableSizePrtDoc);
        for(int i = 1; i <= tablePrint.size(); i++) {
            String joinC1 = txtPrtDoc_C1Part1 + i + txtPrtDoc_C1Part2;
            String joinC3 = txtPrtDoc_C3Part1 + i + txtPrtDoc_C3Part2;
            WebElement column1Documents = driver.findElement(By.xpath(joinC1));
            WebElement column3Print = driver.findElement(By.xpath(joinC3));
            String base = column1Documents.getAttribute("value");
            if (base.length() > 0 ) {
                column3Print.click();
                this.switchPages();
            } else {
                break;
            }
        }
    }

    /* Methods */
    /* Validaciones de tiempo con el status */
    public void waitPass() throws Throwable {
        String status = driver.findElement(messageStatus).getText();
        /*System.out.println("Init: " +  test);*/
        int cont = 1;
        while (status.equalsIgnoreCase("PROCESANDO...")
                || status.equalsIgnoreCase("POR FAVOR ESPERE A QUE EL PROCESO ACTUAL TERMINE.")
                || status.equalsIgnoreCase("CARGANDO FORMULARIO...")
                && cont < 120) {
            cont++;
            Thread.sleep(500);
            status = driver.findElement(messageStatus).getText();
            /*System.out.println("cont = " + cont);
            System.out.println("test = " + test);*/
        }
        /*System.out.println("Finish: " +  test);*/
    }

    /* Cambio de páginas al generar reporte */
    public void switchPages() throws Throwable {
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
                driver.findElement(viewStrace).click();
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
    }
}
