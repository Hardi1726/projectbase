Feature: Manage Pets in Petstore API

  @petstoreTest
  Scenario: Add, retrieve, update, and delete a pet
    Given the Petstore API is available
    When I add a new pet with ID "12345" and name "Fluffy"
    Then I should retrieve the pet with ID "12345"
    When I update the pet name to "Buddy"
    Then I should verify the pet name is updated to "Buddy"
    When I delete the pet with ID "12345"
    Then I should verify the pet is deleted successfully
