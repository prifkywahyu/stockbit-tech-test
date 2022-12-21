@buyProduct
  Feature: User succesfully buy product
    Buy with selected color and quantity

  Scenario: Buy sauce lab back packs product
    Given User choose the product
    When User select color and quantity
    And User click button add to cart
    Then Cart is correct and proceed to checkout
    When User input username and password
    And User click button login
    When User fill in address delivery data
    And User fill in payment method detail
    When User review data and place order
    Then User successfully created an order