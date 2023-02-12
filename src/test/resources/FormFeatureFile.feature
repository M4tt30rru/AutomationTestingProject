Feature: Liferay Form

  Scenario Outline: Filling in data in the form and submit
    Given A user landing on the form page
    When the user fills in the <Football.Player> input
    And the user fills in the <LifeRay.Foundation.Date> input
    And the user fills in the <Test.Field> input
    And the user clicks on the submit button
    Then A message showing the following <Message> shows up

    Examples:
      | Football.Player | LifeRay.Foundation.Date | Test.Field         | Message             |
      | "Pele"          | "01/01/2000"            | "'cause it's cool" | "Tipo di struttura" |