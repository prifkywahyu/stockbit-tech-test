@beers
Feature: Get Beers
  All scenarios to get beers list

  @positiveTest
  Scenario: Success get default beers list
    Given Get default beers list
    When Response code should equal to 200
    Then Return success beers list response

  @positiveTest
  Scenario Outline: Success get beers with pagination
    Given Get beers list with per page "<per_page>"
    When Response code should equal to 200
    And Return success beers list response
    Then Total amount data should be equals to "<per_page>"
    Examples:
      | per_page  |
      | 20        |
      | 5         |
      | 1         |

  @negativeTest
  Scenario: Failed get single beer list
    Given Get single beer with id "31790625"
    When Response code should equal to 404
    Then Return failed beers list response