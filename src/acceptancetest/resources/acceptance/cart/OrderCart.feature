Feature:
  In order to purchase books
  As a customer
  I want to pass an order of my cart content

  Scenario:
  Order my cart purchases
    Given My cart contains
      | Book             | Price | Quantity |
      | Ubuntu in action | 900   | 2        |
    And I pass an order
    When I specify the next order details
      | Customer name | Customer phone | Expedition date |
      | Hares Faiez   | 26871788       | 08/05/2016      |
    Then The order should be passed successfully

  Scenario:
  Modify my order before the expedition date
#    Given I pass an order with thw books
#      | Book             | Price | Quantity |
#      | Debian in action | 300   | 4        |
#    And I pass an order
#    And the details
#      | Customer name | Customer phone | Expedition date |
#      | Hares Faiez   | 26871788       | 08/05/2016      |
#    And To day is "01/01/2016"
#    When I modify the next details about payment method
#      | Customer name | Customer phone | Expedition date |
#      | Hares Faiez   | 26871788       | 08/05/2017      |
#    Then The modification should be considered