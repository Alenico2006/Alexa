Feature: Searching Alexa item

  Scenario: Search Alexa on Amazon

    Given the user navigates to Amazon web page
    And Searches for ‘Alexa’
    And navigates to the second page
    And selects the third item
    Then the "Currently unavailable." option should be visible for user to purchase