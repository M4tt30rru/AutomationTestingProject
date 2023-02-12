Feature: Liferay Form

  Scenario Outline: Filling in data in the form and submit
    Given A user landing on the form page
    When the user fills <Football.Player> value in the football player input
    And the user fills <LifeRay.Foundation.Date> value in the LifeRay foundation input
    And the user fills <Test.Field> value in the career question input
    And the user clicks on the submit button
    Then A message showing the following <Message> shows up

    Examples:
      | Football.Player | LifeRay.Foundation.Date | Test.Field         | Message     |
      | "Pele"          | "01/01/2000"            | "'cause it's cool" | "Thank you" |
      # testing empty string insertion
      | ""              | ""                      | ""                 | "Thank you" |
      # only 1 empty string
      | ""              | "01/01/2000"            | "'cause it's cool" | "Thank you" |
      | "Pele"          | ""                      | "'cause it's cool" | "Thank you" |
      | "Pele"          | "01/01/2000"            | ""                 | "Thank you" |
      # 2 out of 3 empty strings
      | ""              | ""                      | "'cause it's cool" | "Thank you" |
      | "Pele"          | ""                      | ""                 | "Thank you" |
      | ""              | "01/01/2000"            | ""                 | "Thank you" |
      # 1 space string for football player
      | " "             | "01/01/2000"            | ""                 | "Thank you" |
      # 1 space string for career field
      | ""              | "01/01/2000"            | " "                | "Thank you" |
      # 2 space string for football and career field
      | " "             | "01/01/2000"            | " "                | "Thank you" |
      | " random name"  | "01/01/2000"            | " random text"     | "Thank you" |

  Scenario Outline: Filling in football player field in the form and submit
    Given A user landing on the form page
    When the user fills <Football.Player> value in the football player input
    And the user fills <LifeRay.Foundation.Date> value in the LifeRay foundation input
    And the user fills <Test.Field> value in the career question input
    And the user clicks on the submit button
    Then A message showing the following <Message> shows up

    Examples:
      | Football.Player       | LifeRay.Foundation.Date | Test.Field         | Message     |
      # wrong name for football player
      | "12345"               | "01/01/2000"            | "'cause it's cool" | "Thank you" |
      | "example@example.com" | "01/01/2000"            | "'cause it's cool" | "Thank you" |

  Scenario Outline: Filling in the date field in the form and submit
    Given A user landing on the form page
    When the user fills <Football.Player> value in the football player input
    And the user fills <LifeRay.Foundation.Date> value in the LifeRay foundation input
    And the user fills <Test.Field> value in the career question input
    And the user clicks on the submit button
    Then A message showing the following <Message> shows up

    Examples:
      | Football.Player | LifeRay.Foundation.Date | Test.Field         | Message     |
      # wrong date
      | "Ronaldo"       | "01/01/2050"            | "'cause it's cool" | "Thank you" |
      # wrong date format: day, month, year instead of month, day year (for the US page)
      | "Ronaldo"       | "31/03/2000"            | "'cause it's cool" | "Thank you" |
      # wrong date, correct format: 30th Feb 2000
      | "Ronaldo"       | "02/30/2000"            | "'cause it's cool" | "Thank you" |
      # wrong date, wrong format. day, month, year 30/02/2000
      | "Ronaldo"       | "30/02/2000"            | "'cause it's cool" | "Thank you" |
