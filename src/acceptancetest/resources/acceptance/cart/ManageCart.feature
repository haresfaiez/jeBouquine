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

  Scenario:
  Modify purchases quantity in my cart
#    Given My cart contains
#      | Book             | Price | Quantity |
#      | Funtoo in action | 300   | 4        |
#    When I modify the quantity of the book "Funtoo in action" to "10"
#    Then the cart should contains
#      | Book             | Price | Quantity |
#      | Funtoo in action | 300   | 10       |
