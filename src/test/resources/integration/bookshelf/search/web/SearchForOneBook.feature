Feature:
  Retrieve a book by ISBN through the web UI

  Scenario Outline:
  Search for an existing book by ISBN through the web UI
    Given the catalog contains a book with ISBN "<ISBN>" and title "<BookTitle>"
    When  we search for a book with ISBN "<ISBN>" through the web UI
    Then  we should get the book model
  Examples:
    | ISBN | BookTitle       |
    | QBVS | HibernateIsCool |

  Scenario Outline:
  Search for a non existing book by ISBN through the web UI
    Given the catalog contains no books
    When  we search for a book with ISBN "<ISBN>" through the web UI
    Then  we should not get a book model
  Examples:
    | ISBN |
    | QQQQ |