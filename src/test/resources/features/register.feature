@Registration
Feature: Student Registration
  yo como usario de la aplicación demoqa
  quiero llenar el formulario de incripcion
  para obtener los beneficios de la pagina

  Background: registration page
    Given the user is in the registration page

  Scenario: successful register
    When he enters his information
    And he submits the data
    Then he should see a thanks message

  @date
  Scenario Outline: date picker input
    When he enters <date> info
    Then he should see the field as valid
    Examples:
      | date         |
      | "1997-03-07" |
      | "2020-11-11" |
#      | "2999-09-20" |
