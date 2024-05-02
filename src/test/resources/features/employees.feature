@Employees
Feature: Employee users management

  @AddEmployee
  Scenario: Add employee record
    Given User is in the employee's page
    When he adds a new record to the table
    Then he should see the created record