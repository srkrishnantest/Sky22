#Author: Shan Radhakrishnan
#Keywords Summary : Sky Test
# Tag3 is hidden due to the limitations mentioned in email as well as TypeRunner header
@tag
Feature: This feature will make sure that the shop page is navigable and usable

  @tag1
  Scenario: User navigates to shop page
    Given I am on the home page
    When I navigate to Deals
    Then the user should be on the deals page

  @tag2
  Scenario: User sees a list of deals on the deals page
    Given I am on the deals page
    Then I see a list of deals with a price to it

  @tag3
  Scenario: User sees tiles on the shop page
    Given I am on the home page
    When I try to sign in with invalid credentials
    Then I should see a text saying that Sorry, we did not recognise either your username or password

  @tag4
  Scenario: User sees the editorial section in specific searches
    Given I am on the home page
    When I search sky in the search bar
    Then I should see an editorial section
