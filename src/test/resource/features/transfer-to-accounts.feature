Feature: Transfer money to any nominated account 2

  Scenario: Transfer money from any personal account to any other personal accounts
    Given I have deposited 1000 into my "current" Account
	When I transfer 50 from my "savings" Account to my "cheque" Account
    Then the "current" Account will be 1000 less
    And the "cheque" Account will be 1000 more