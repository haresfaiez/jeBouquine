Feature:
  In order to pay my shopping session books together
  As a customer
  I want to add books to my cart

  Scenario:
  Add books to the cart
    Given I am
      | Username       | Password | Role     |
      | faiez_customer | 0000     | customer |
    And the catalog contains these books
      | ISBN  | Title             | Price | Summary | Author |
      | ABTC1 | Clojure in action | 300   | Clojure | Faiez  |
      | ABTC2 | Groovy in action  | 900   | Groovy  | Faiez  |
    When I add the next books to my cart
      | ISBN  | Title             | Price | Summary | Author |
      | ABTC1 | Clojure in action | 300   | Clojure | Faiez  |
      | ABTC2 | Groovy in action  | 900   | Groovy  | Faiez  |
    Then I should find these entries in my cart
      | Book  | Price |
      | ABTC1 | 300   |
      | ABTC2 | 900   |
    And the total price should be "1200"

  Scenario:
  Keep the cart out of the current shopping session
    Given I am
      | Username       | Password | Role     |
      | faiez_customer | 0000     | customer |
    And the catalog contains these books
      | ISBN  | Title          | Price | Summary | Author |
      | ABTC4 | Rust in action | 300   | Rust    | Faiez  |
    And I add these books to my cart
      | ISBN  | Title          | Price | Summary | Author |
      | ABTC4 | Rust in action | 300   | Rust    | Faiez  |
    When I come back to a new shopping session
    Then I should find the books in my cart
