Feature:
  In order to have a delightful shopping session
  As a customer
  I want to manage my cart

  Scenario:
  Remove purchases from my cart
    Given My cart contains
      | Book           | Price | Quantity |
      | LFS in action  | 300   | 4        |
      | Arch in action | 900   | 2        |
    When I remove the last book purchase
    Then The cart should contains just the first book
