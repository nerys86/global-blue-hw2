Feature: Retrieve Posts

  Scenario: Retrieve all posts
    Given the API is available
    When I send a GET request to "/posts"
    Then the response status code should be 200
    And the response header should be "application/json"
    And the response should contain a list of posts
    And each post should have "id", "title", "content", and "userId"

  Scenario: Retrieve a single post by ID
    Given the API is available
    And a post with ID 1 exists
    When I send a GET request to "/posts/1"
    Then the response status code should be 200
    And the response header should be "application/json"
    And the response should contain the post with ID 1
    And the post should have "title", "content", and "userId"
