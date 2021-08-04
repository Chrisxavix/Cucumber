Feature: Transacciones de Inversiones
  Background:
    Given Abre el web browser Chrome y direcciona a la aplicacion
    When Cierro de sesiones activas e engreso el usuario UE0100066B y la contrasena chris012345
    Then Visualizo el menu principal
    When Ingreso la transaccion 05-2000
    Then Visualizo el estado de la transaccion
    When Lleno el item de datos generales: titular y cotitulares, datos de la cuenta y datos del certificado

  Scenario: Renovacion Automatica de Capital ativada y Capitalizacion de Intereses activada
    And Detallo renovacion automatica en true y capitalizacion de intereses en true
    And Lleno el item de datos generales: datos del certificado y firmas
    Then Genero el reporte
    And Guardo el formulario
    And Confirmo la creacion del numero de solicitud
    When LLeno el formulario de detalle de la solicitud de fondos
    Then Guardo el formulario
    And Valido el formulario de detalle de la solicitud de fondos
    When LLeno el formulario de detalle de ingreso de fondos
    Then Guardo el formulario
    And Valido el formulario de detalle de ingreso de fondos
    And Cierro el Browser

  Scenario: Renovacion Automatica de Capital ativada y Capitalizacion de Intereses desactivada
    And Detallo renovacion automatica en true y capitalizacion de intereses en false
    And Lleno el item de datos generales: datos del certificado y firmas
    Then Genero el reporte
    And Guardo el formulario
    And Confirmo la creacion del numero de solicitud
    When LLeno el formulario de detalle de la solicitud de fondos
    Then Guardo el formulario
    And Valido el formulario de detalle de la solicitud de fondos
    When LLeno el formulario de detalle de ingreso de fondos
    Then Guardo el formulario
    And Valido el formulario de detalle de ingreso de fondos
    And Cierro el Browser


