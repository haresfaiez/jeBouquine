Feature:
  In order to have a big picture of the book I will buy
  As a customer
  I want to have all of its details

  Scenario:
    Given the catalog contains these books
      | ISBN | Title      | Price | Summary    | Author |
      | JVVV | Hello Java | 800   | Java book  | Faiez  |
    When I want to buy this book
    Then I should be given all of its details

