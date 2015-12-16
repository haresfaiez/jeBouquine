Feature:
  In order to give a reliable delivery
  As JeBouquine manager
  I want customers to choose their delivery process details


  Scenario:
  Choose delivery process
    Given My cart contains
      | Book             | Price | Quantity |
      | Ubuntu in action | 900   | 2        |
    And I pass an order
    And I specify the next order details
      | Customer name | Customer phone | Expedition date |
      | Hares Faiez   | 26871788       | 08/05/2016      |
    When I give the next delivery process details
      | Payment method | Delivery address |
      | Manual         | Tunis            |

  Scenario:
  Print cart order
