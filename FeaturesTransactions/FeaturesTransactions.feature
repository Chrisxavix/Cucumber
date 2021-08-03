Feature: Transacciones de FitBank
  Historias de Usuario...
  Background:
    Given Abre el web browser Chrome y direcciona a la aplicacion
  Scenario Outline: Flujo de transacciones
    When Cierro de sesiones activas e engreso el usuario "<user>" y la contrasena "<password>"
    Then Visualizo el menu principal
    When Ingreso la transaccion "<transaction>"
    Then Visualizo el estado de la transaccion
    When Lleno los datos generales
    Then Genero el reporte
    And Guardo el formulario
    And Confirmo la creacion del numero de solicitud
    When LLeno el formulario de detalle de la solicitud de fondos
    Then Guardo el formulario
    And Cierro el Browser
    Examples: Login[ usuarios, contrasenas, transacciones]
      | user       | password    | transaction |
      | UE0100066B | chris012345 | 05-2000     |
      #| UE0100066B | chris012345 | 04-6003     |
      #| UE0100066B | chris012345 | 04-1111     |

    #Examples: Formulario[identificacion, relacion, direccion]
    #  | identification | relation | address |
    #  | 1704556644     | TIT      | 1       |

    # Inversión: Ingreso y mantenimiento de depósito a plazos 05-2000
    # Ejemplos:
                # Transacción 04-6003:  Existe
                # Transacción 04-1111:  No Existe
