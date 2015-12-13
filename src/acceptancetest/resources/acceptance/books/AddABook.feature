Feature:
  In order to sell more books
  As a logistic manager
  I want to add new books to the catalog

  Background:
    Given I am
      | Username       | Password | Role             |
      | faiez_logistic | 0000     | logistic manager |
    And I want to add the book
      | ISBN | Title               | Price | Summary | Author |
      | AAB1 | Good evening Spring | 900   | Spring  | Faiez  |

  Scenario: Add a new book to the catalog
    When I add the book to the catalog
    Then the book should be inserted

  Scenario: Add an existing book to the catalog
    But the catalog contains a book with ISBN "SPRG"
    When I add the book to the catalog
    Then I should get an existing book error message
    And I should be given a chance to fix the ISBN
