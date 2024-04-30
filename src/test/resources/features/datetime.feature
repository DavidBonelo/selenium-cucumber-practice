Feature: Date and Time pickers

  Background: date picker page
    Given User in in the date picker page

  @Dates
  Scenario Outline: pick date
    When he picks the date: <date>
    Then he should see the date field filled with <dateText>
    Examples:
      | date         | dateText     |
      | "1985-07-15" | "07/15/1985" |
      | "2075-03-10" | "03/10/2075" |
      | "2099-12-31" | "12/31/2099" |

  @DateTimes
  Scenario Outline: pick date and time
    When he picks the datetime: <dateTime>
    Then he should see the datetime field filled with <dateTimeText>
    Examples:
      | dateTime           | dateTimeText                  |
      | "2024-04-30T12:30" | "April 30, 2024 12:30 PM"     |
      | "2035-09-15T15:45" | "September 15, 2035 3:45 PM" |
      | "2015-11-20T09:00" | "November 20, 2015 9:00 AM"  |