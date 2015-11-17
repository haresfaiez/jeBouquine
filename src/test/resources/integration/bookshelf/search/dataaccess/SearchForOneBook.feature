Feature:
  Retrieve a book by ISBN from the catalog

  Scenario Outline:
  Search for an existing book by ISBN
    Given the catalog contains a book with ISBN "<ISBN>" and title "<BookTitle>"
    When  we try to retrieve a book with ISBN "<ISBN>"
    Then  we should have the book
  Examples:
    | ISBN | BookTitle       |
    | 3456 | HibernateIsCool |

  Scenario Outline:
  Search for a not existing book by ISBN
    Given the catalog contains a no books
    When  we try to retrieve a book with ISBN "<ISBN>"
    Then  we should have an error
  Examples:
    | ISBN |
    | 3333 |