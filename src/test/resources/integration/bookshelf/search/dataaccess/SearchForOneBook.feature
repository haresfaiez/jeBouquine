Feature:
  Retrieve a book by ISBN from the data source

  Scenario Outline:
  Search for an existing book by ISBN in the catalog
    Given the data source contains a book with ISBN "<ISBN>" and title "<BookTitle>"
    When  we try to retrieve a book with ISBN "<ISBN>" from the data source
    Then  we should get the book instance
  Examples:
    | ISBN | BookTitle       |
    | 3456 | HibernateIsCool |

  Scenario Outline:
  Search for a non existing book by ISBN in the catalog
    Given the data source contains a no books
    When  we try to retrieve a book with ISBN "<ISBN>" from the data source
    Then  we should not get a book instance
  Examples:
    | ISBN |
    | 3333 |