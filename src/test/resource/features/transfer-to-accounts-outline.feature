Feature: Checkout

  Scenario Outline: Transfer money from any personal account to any other personal accounts outline
    #Given I have deposited <deposit> into my <from> Account
    Given my <from> account has been credited <deposit>
    When I transfer <transfer> from my <from> Account to my <to> Account
    Then the <from> Account will be <transfer> less
    And the <to> Account will be <transfer> more

    Examples:
      | deposit | from    | to      | transfer |
      | 1000.00 | savings | cheque  | 40.00    |
      | 2000.00 | current | savings | 80.00    |