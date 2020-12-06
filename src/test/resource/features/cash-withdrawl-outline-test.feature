Feature: Cash Withdrawal

  Scenario Outline: Successful withdrawal from an account in credit
    Given my <fromAccount> account has been credited <deposit>
    When I withdraw <request>
    Then <dispense> should be dispensed
    And the balance of my <fromAccount> account should be <accountBalance>

    Examples:
      | deposit | request | dispense | fromAccount | accountBalance |
      | 100.00  | 20.00   | 20.00    | savings     | 80.00          |
#      | 333.00  | 50.00   | 50.00    | savings     | 283.00         |

