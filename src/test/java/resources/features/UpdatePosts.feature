Feature: Update Posts

  Scenario: Update an existing post
    Given the API is available
    And a post with ID 1 exists
    When I send a PUT request to "/posts/1" with the updated payload
    Then the response status code should be 200
    And the response should contain the updated post data
