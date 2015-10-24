Feature:
  As a customer
  I want to search for a book details
  In order to choose whatever I will buy it or not

  Scenario Outline:
    Search for an existing book by ISBN
    Given There is a book in the catalog with ISBN "<ISBN>" and title "<BookTitle>"
    When  The customer search for the book by ISBN "<ISBN>"
    Then  It should receive the book details
    Examples:
      | ISBN | BookTitle       |
      | 1111 | HelloWorld      |
      | 3456 | HibernateIsCool |