@Navigation
Feature: Navigation bar
To see the subpages
Whitout logging in
I can click the navigation bar links

Background: Im on the Free Range Testers web without logging in
Given I navigate to www.freerangetesters.com

Scenario: I can access the subpages through the navigation bar
# Use of background in the scenario
When I go to the course

Scenario Outline: I can access the subpages through the navigation bar
When I go to <section> using the navigation bar
Examples:
    | section |
    | Cursos |
    | Recursos |
    | Udemy |
    | Mentorías |
    | Newsletter |

Scenario: courses are presented correctly to potential customers
When The user select Elegir Plan
And The client select Introduction to Testing

@Plans
Scenario: user can select a plan when singning up
When The client select Elegir Plan
Then The user can validate the options in the checkout page