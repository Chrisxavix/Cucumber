Feature: Transacciones de FitBank
  Background:
    Given Abre el web browser Chrome y direcciona a la aplicacion
  Scenario Outline: Flujo de transacciones
    When Ingreso el usuario "<user>" y la contrasena "<password>"
    Then Visualizo el menu principal
    When Ingreso la transaccion "<transaction>"
    Then Visualizo el estado de la transaccion
    And Cierro el Browser
    Examples:
      | user       | password    | transaction |
      | UE0100066B | chris012345 | 04-6003     |
      | UE0100066B | chris012345 | 04-1111     |
      | UE0100066B | chris012345 | 04-1     |

    # Transacción 04-6003:  Existe
    # Transacción 04-1111:  No Existe
    # Transacción 04-1:     Error de Validación Fronted

