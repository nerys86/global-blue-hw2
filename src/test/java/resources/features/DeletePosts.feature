Feature: Post deletion

  Scenario: Delete a post
    Given the API is available
    And a post with ID 1 exists
    When I send a DELETE request to "/posts/1"
    And the response status code should be 200
