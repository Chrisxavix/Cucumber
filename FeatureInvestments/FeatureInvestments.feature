Feature: Transacciones de Inversiones
  Background:
    Given Abre el web browser Chrome y direcciona a la aplicacion
    When Cierro sesiones activas e ingreso el usuario UE0100066B y la contrasena chris012345
    Then Visualizo el menu principal
    When Ingreso la transaccion 05-2000
    Then Visualizo el estado de la transaccion
    When Lleno el item de datos generales: titular y cotitulares, datos de la cuenta y datos del certificado

  Scenario: Renovacion Automatica de Capital ativada y Capitalizacion de Intereses activada
    And Selecciono la renovacion automatica en true y capitalizacion de intereses en true
    And Lleno el item de datos generales: datos del certificado y firmas
    And Genero el reporte
    And Guardo el formulario
    Then Valido el formulario
    When LLeno el formulario de detalle de la solicitud de fondos
    And Guardo el formulario
    Then Valido el formulario
    When LLeno el formulario de detalle de ingreso de fondos
    And Guardo el formulario
    Then Valido el formulario
    When Selecciono y visualizo la tabla de pagos
    Then Valido el formulario
    When Selecciono y visualizo la impresion de documentos
    Then Valido el formulario
    And Imprimo los documentos
    And Abrir ventana nueva y redirigir a la transaccion 05-4000
    Then Visualizo el estado de la transaccion
    And Cierro el Browser

#  Scenario: Renovacion Automatica de Capital ativada y Capitalizacion de Intereses desactivada
#    And Selecciono la renovacion automatica en true y capitalizacion de intereses en false
#    And Lleno el item de datos generales: datos del certificado y firmas
#    And Genero el reporte
#    And Guardo el formulario
#    Then Valido el formulario
#    When LLeno el formulario de detalle de la solicitud de fondos
#    And Guardo el formulario
#    Then Valido el formulario
#    When LLeno el formulario de detalle de ingreso de fondos
#    And Guardo el formulario
#    Then Valido el formulario
#    When Lleno el formulario de pagos
#    Then Valido el formulario
#    When Selecciono y visualizo la tabla de pagos
#    Then Valido el formulario
#    When Selecciono y visualizo la impresion de documentos
#    Then Valido el formulario
#    And Imprimo los documentos
#    And Cierro el Browser


