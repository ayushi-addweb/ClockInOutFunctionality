
Feature: Clock In and Out Functionality
  Scenario: To check Clock In and Out Functionality is working or not
    Given User is on dashboard page
    When User clicks on Clock In button
    Then User Clocked In time and System time is display or not
    And Clocked In time and System time is match
    Given User is on the Attendance page
    And User is going on the Dashboard page
    When User clicks on the Clocked out button
    Then User successfully clock out