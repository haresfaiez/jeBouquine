Feature:
  In order to buy a book
  As a customer
  I want to search for any existing book details

  Background:
    Given the catalog contains these books
      | ISBN  | Title               | Price | Summary | Author |
      | SFAB1 | Good morning Spring | 500   | Spring  | Faiez  |
      | SFAB2 | Good morning Java   | 400   | Java    | Faiez  |
      | SFAB3 | Good evening Gradle | 450   | Gradle  | Faiez  |

  Scenario:
  Search for one existing book by ISBN
    When  I search for a book with ISBN "SFAB1"
    Then  I should get the book details

  Scenario:
  Search for a book by title
    When I search for a book with title "Good morning"
    Then I should get the books below
      | ISBN  | Title               | Price | Summary | Author |
      | SFAB1 | Good morning Spring | 500   | Spring  | Faiez  |
      | SFAB2 | Good morning Java   | 400   | Java    | Faiez  |

  #TODO:enable the next scenario
#The book doesn't exist in the catalog
#  Scenario:
#  Search for a non existing book by ISBN
#    When  I search for a book with ISBN "QQQQ"
#    Then  I should get a missing book message