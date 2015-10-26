Scenario:  Search for a single existing book by ISBN from the catalog

Given There is a book in the catalog with ISBN "<ISBN>" and title "<BookTitle>"
When  The customer search for the book by ISBN "<ISBN>"
Then  It should receive the book details
Examples:
      | ISBN | BookTitle       |
      | 1111 | HelloWorld      |
      | 3456 | HibernateIsCool |