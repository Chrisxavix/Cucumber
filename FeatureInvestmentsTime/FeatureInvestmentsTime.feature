Feature: Transacciones de Inversiones
  Background:
    Given Abre el web browser Chrome y direcciona a la aplicacion
    When Cierro sesiones activas, ingreso el usuario UE0100066B y la contrasena chris012345
    Then Ingreso la transaccion 05-2000
    When Ingreso informacion en el item de datos generales: titular y cotitulares, datos de la cuenta y datos del certificado

  Scenario: Renovacion Automatica de Capital ativada y Capitalizacion de Intereses activada en el item de datos generales
    And Selecciono la renovacion automatica en true y capitalizacion de intereses en true en el item de datos generales
    And Ingreso informacion en el item de datos generales: firmas
    And Genero el reporte
    Then Guardo el formulario
    And Valido el estado de la transaccion
    When Selecciono la pestana de detalle de la solicitud de fondos
    And Ingreso informacion en el formulario de detalle de la solicitud de fondos
    Then Guardo el formulario
    And Valido el estado de la transaccion
    When Selecciono la pestana de detalle de ingreso de fondos
    And Ingreso informacion en el formulario de detalle de ingreso de fondos
    Then Guardo el formulario
    And Valido el estado de la transaccion
    When Selecciono la pestana de tabla de pagos
    Then Valido el estado de la transaccion
    When Selecciono la pestana de impresion de documentos
    Then Valido el estado de la transaccion
    And Imprimo los documentos

  Scenario: Renovacion Automatica de Capital ativada y Capitalizacion de Intereses desactivada
    And Selecciono la renovacion automatica en true y capitalizacion de intereses en false en el item de datos generales
    And Ingreso informacion en el item de datos generales: firmas
    And Genero el reporte
    Then Guardo el formulario
    And Valido el estado de la transaccion
    When Selecciono la pestana de detalle de la solicitud de fondos
    And Ingreso informacion en el formulario de detalle de la solicitud de fondos
    Then Guardo el formulario
    And Valido el estado de la transaccion
    When Selecciono la pestana de detalle de ingreso de fondos
    And Ingreso informacion en el formulario de detalle de ingreso de fondos
    Then Guardo el formulario
    And Valido el estado de la transaccion
    When Selecciono la pestana de pagos
    Then Valido el estado de la transaccion
    When Selecciono la pestana de tabla de pagos
    Then Valido el estado de la transaccion
    When Selecciono la pestana de impresion de documentos
    Then Valido el estado de la transaccion
    And Imprimo los documentos
