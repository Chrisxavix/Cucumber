Feature: Transacciones de FitBank
  Historias de Usuario...
  Background:
    Given Abre el web browser Chrome y direcciona a la aplicacion
  Scenario Outline: Flujo de transacciones
    When Selecciono cierre de sesiones activas
    Then Marco forzar cierre
    When Ingreso el usuario "<user>" y la contrasena "<password>"
    Then Visualizo el menu principal
    When Ingreso la transaccion "<transaction>"
    Then Visualizo el estado de la transaccion
    When Lleno los datos generales de titulares y cotitulares
    And Lleno los datos de datos de la cuenta
    And Lleno los datos de datos del certificado
    And Copio los datos ingresados en titulares en firmas autorizadas
    And Genero el reporte
    Then Guardo el formulario
    And Y confirmo la creacion del numero de solicitud
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
