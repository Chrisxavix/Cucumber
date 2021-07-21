Feature: Funcionalidad de login
  Scenario: Ingresar datos del usuario
    Given Abre el web browser Chrome y direcciona a la aplicacion
    When Ingreso el usuario y clave
    Then Visualizo resultado
    And Cierro el Browser
