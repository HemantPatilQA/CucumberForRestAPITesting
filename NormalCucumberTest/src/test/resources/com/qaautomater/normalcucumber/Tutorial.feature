Feature:
  Scenario: User wants to create a new tutorial
    Given the tutorial-service is up and running
    When the user sends a valid request to create tutorial
      | Learning JPA | Learn JPA from scratch | true |
    Then A new tutorial is created and user is notified with new Id
    And Validate response has status code