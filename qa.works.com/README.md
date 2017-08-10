Author :Timothy Ajisafe
Cucumber JVM Test framework

Summary
A behaviour-driven development (BDD) automation test framework written in JAVA (maven project).

Dependencies
- Cucumber JVM
- Selenium Java
- Hamcrest Core
- log4j

Cucumber feature file :

Feature: Contact Us Page
  As an end user
  I want a contact us page
  So that I can find out more about QAWorks exciting services!!
  Scenario: Valid Submission
    Given I am on the "Home Page - QAWorks"
    When I navigate to the contact us page
    Then I should be able to contact QAWorks with the following information
      | name    | j.Bloggs                                  |
      | email   | j.Bloggs@qaworks.com                      |
      | message | please contact me I want to find out more |


Instructions for Running the Tests:

-	Run maven command from the command prompt
1.  Clone the github repository
2.	Open a command prompt in the directory of the folder 
3.	Run maven command (mvn test -PqaWorksTestRunner test) 

-	Run via JUnit on the IDE
1.	Run as Junit Test (runner class – qaWorksTestRunner.java)


Report: html report can be viewed in the paths below:
              qaWorksTestReport/html/index.html
