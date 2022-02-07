Feature: Board API Tests

  Scenario: Get all users boards list
    Given Boards list do exist
    Then Board list contains
      | Work   |
      | MARVEL |


  Scenario: Create a Board
    Given Boards list do exist
    Given Board with name "Test" do not exist if yes delete this board
    When  I want to create a board with name "Test"
    When I stared new board
    Then  Board was created
    Given Boards list do exist
    Then Board list contains
      | Test |