@tag2
Feature: Edit any user Information
  Scenario: user make all fields empty
    Given the user in profile page
    When the user click on editBtn amd all field empty
    Then the alert appear that the field are Empty

    Scenario: user set new userName
      Given the user in profile page
      When the user click on editBtn and the UserName only fill with new userName "Osama2"
      Then the alert appear that the User Name change success

  Scenario: user set new Password
    Given the user in profile page
    When the user click on editBtn and the password only fill with new userName "Osama2"
    Then the alert appear that the Password change success


  Scenario: user set new Email
    Given the user in profile page
    When the user click on editBtn and the UserName only fill with new Email "Osama2@gmail.com"
    Then the alert appear that the Email change success