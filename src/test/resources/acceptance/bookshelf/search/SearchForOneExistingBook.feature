Feature:
  As a customer
  I want to search for a book details
  In order to decide whatever I will buy it or not

  Background:
    Given the catalog contains these books
      | ISBN | BookTitle       |
      | QBVS | HibernateIsCool |

  Scenario:
  Search for one existing book by ISBN
    When  I search for a book with ISBN "QBVS"
    Then  I should get the book

   #The book doesn't exist in the catalog
  Scenario:
  Search for a non existing book by ISBN
    When  I search for a book with ISBN "QQQQ"
    Then  I should get an missing book message