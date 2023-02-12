Feature: Liferay Form

  Scenario Outline: Filling in data in the form and submit
    Given A user landing on the form page
    When the user fills <Football.Player> value in the football player input
    And the user fills <LifeRay.Foundation.Date> value in the LifeRay foundation input
    And the user fills <Test.Field> value in the career question input
    And the user clicks on the submit button
    Then A message showing the following <Message> shows up

    Examples:
      | Football.Player | LifeRay.Foundation.Date | Test.Field         | Message             |
      | "Pele"          | "01/01/2000"            | "'cause it's cool" | "Thank you" |