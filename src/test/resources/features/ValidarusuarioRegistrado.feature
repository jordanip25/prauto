Feature: Validacion de usuario al termino de registro

  Scenario Outline: Quiero validar el registro de una persona

    Given que la web de orange este disponible
    When ingreso mis credenciales para loguearme a la pagina
    And accedo a la sección de agregar usuarios con todo y detalle
    And me registro correctamente con los siguientes datos "<primernombre>" "<segundonombre>"  "<lastname>" "<id>" "<username>" "<password>" "<cpassword>"
    Then ingreso a la sección de los usuarios registrados buscando por mi "<id>"
    And verifico que el usuario que he registrado se visualize viendo mi  "<id>"  "<lastname>"
    Examples:
      | primernombre | segundonombre  | lastname | id | username | password  | cpassword |
      | Maria         | Fernanda    | Pilar  | 0808 | mpilar | mpilar123 | mpilar123 |