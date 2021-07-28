Feature: Funcionalidad de login
  Scenario Outline: Ingresar datos del usuario
    Given Abre el web browser Chrome y direcciona a la aplicacion
    When Ingresa el usuario "<user>" y contrasena "<password>"
    Then Visualizo resultado
    And Cierro el Browser
    Examples:
      | user       | password    |
      | UE0100066B | chris012345 |
      | UE0100066B | chris012345 |