Feature: Mouse Interactions

  @Interactions
  Scenario: Drag and drop
    Given User is in the droppable page
    When he drags and drops the box to its place
    Then he should see the droppable place reaction