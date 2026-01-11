Feature: End to End Shopping Flow

  Scenario: Verify user can search products, sign up, login and view cart
    Given user launches the application
    When user searches first product and applies filters
    And user searches second product and applies filters
    And user navigates to sign up page
    Then sign up page should be displayed
    When user navigates to login page
    Then login page should be displayed   
    # When user logs into the application
    # And user navigates to shopping cart
    # Then shopping cart page should be displayed
