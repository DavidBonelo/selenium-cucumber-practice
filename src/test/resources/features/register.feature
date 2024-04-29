@Registration
Feature: Student Registration
  yo como usario de la aplicación demoqa
  quiero llenar el formulario de incripcion
  para obtener los beneficios de la pagina

  Scenario: inscripción correcta
    Given the user is in the registration page
    When he enters his information
    And he submits the data
    Then he should see a thanks message