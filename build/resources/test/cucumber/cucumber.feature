Feature: Web page registration

  Scenario: Successfully registration when user is not register
    Given User with registration false
    When User try to register with username Pepito and password Pepito123
    Then User is register

  Scenario: User cannot register when its already
    Given User with registration true
    When User try to register with username Pepito and password Pepito123
    Then Operation must throw UserAlreadyRegisteredException

  Scenario: User adds money to his balance
    Given User with registration true
    When User adds 100 dollars to his balance
    Then User have 100 dollars


