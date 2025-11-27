Feature: Post creation

  Scenario Outline: Create a new post
    Given the API is available
    When I send a POST request to "/posts"
    Then the response status code should be 200
    And the response header should be "application/json"
    And the response should contain the created post
    And the created post should have "<title>" in "title", "<content>" in "content", and "<userId>" in "userId"

    Examples:
      | title         | content                              | userId |
      | Updated Title | This is the updated body of the post | 1      |

