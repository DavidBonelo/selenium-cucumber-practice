@Interactions
Feature: Mouse Interactions

  @DragNDrop
  Scenario: Drag and drop
    Given User is in the droppable page
    When he drags and drops the box to its place
    Then he should see the droppable place reaction

  @Sorting
  Scenario Outline: Sort list items
    Given User is in the sortable page
    When he moves <target> to <index> position
    Then he should see the <target> at <index> position
    Examples:
      | target | index |
      | "Two"  | 4     |
      | "Four" | 1     |
