Feature:
  In order to pay my shopping session books together
  As a customer
  I want to add books to my cart

  Scenario:
  Add books to the cart
    Given I am the customer
      | Username       | Password |
      | faiez_customer | 0000     |
    And The books I want to buy are
      | ISBN  | Title             | Price | Summary | Author |
      | ABTC1 | Clojure in action | 300   | Clojure | Faiez  |
      | ABTC2 | Groovy in action  | 900   | Groovy  | Faiez  |
    When I add them to my cart
    Then the total price should be "1200"
    And I should find these purchases in my cart
      | Book              | Price |
      | Clojure in action | 300   |
      | Groovy in action  | 900   |

  Scenario:
  Keep the cart purchases out of the current shopping session
    Given I am the customer
      | Username       | Password |
      | faiez_customer | 0000     |
    And The books I want to buy are
      | ISBN  | Title            | Price | Summary | Author |
      | ABTC3 | Golang in action | 300   | Golang  | Faiez  |
      | ABTC4 | Perl in action   | 900   | Perl    | Faiez  |
    When I add them to my cart
    And I come back to a new shopping session
    Then I should find these purchases in my cart
      | Book             | Price |
      | Golang in action | 300   |
      | Perl in action   | 900   |
