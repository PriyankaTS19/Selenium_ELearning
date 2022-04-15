Feature: Automate eLearning Site

  Scenario: 
    Given the user opens the eLearning site
    When the user clicks on signUp
    Then the user need to fill up the regestiation form for all mandatory fields 
      | First Name | test           |
      | Last Name  | user           |
      | Email      | test@gmail.com |
      | Username   | usertest12     |
      | Password   | Happy123       |
    When the user submits the details
    #Then the user should see the message saying "Your personal settings have been registered."
    When the user clicks on Next button
    Then the user is navigated to HomePage
    When the user clicks the username icon
    And the user choose profile from Dropdown
    And the user clicks on Messages
    And the user clicks on Compose message
    And the user enters the details shown on the page
      #| Send To     | abc        |
      | Subject     | testing     |
      #| Message     | message     |
      #| Description | description |
    And the user should click on Send message
