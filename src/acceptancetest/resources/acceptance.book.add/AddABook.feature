Feature:
  In order to have more books sells
  As a logistic manager
  I want to add new books to the catalog

  Background:
    Given I am
    |username      |password|role            |
    |faiez_logistic|0000    |logistic manager|
    And I want to add the book

  Scenario: Add a new book to the catalog
    When I add the book to the catalog
    Then the book should be inserted to the catalog
    And It should be highliten to all the clients

  Scenario: Add an existing book to the catalog
    But the catalog contains a book with ISBN ""
    When I add the book to the catalog
    Then I should get an existing book error message
    And I should be given a chance to fix the ISBN
