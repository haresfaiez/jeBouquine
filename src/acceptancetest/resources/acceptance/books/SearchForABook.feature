Feature:
  In order to buy a book
  As a customer
  I want to search for any existing book details

  Background:
    Given the catalog contains these books
      | ISBN | Title               | Price | Summary | Author |
      | QBVS | Good morning Spring | 500   | Spring  | Faiez  |

  Scenario:
  Search for one existing book by ISBN
    When  I search for a book with ISBN "QBVS"
    Then  I should get the book details

   #The book doesn't exist in the catalog
  Scenario:
  Search for a non existing book by ISBN
    When  I search for a book with ISBN "QQQQ"
    Then  I should get a missing book message