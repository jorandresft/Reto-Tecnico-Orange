Feature: Validate Recruitment functionality in the web site Orange HRM

  Background:
    Given The "user" open the web site

  @successful
  Scenario Outline: Validate the Recruitment functionality with status Hired
    And init session with his credentials username "Admin" and password "admin123"
    And select Recruitment and click on add
    When fill all field required
      | firstName   | lastName   | vacancy   | email   | contactNumber   | keywords   |
      | <firstName> | <lastName> | <vacancy> | <email> | <contactNumber> | <keywords> |
    And click on Shortlist and Save
    And click on Schedule Interview and fill all field required
      | interviewTitle | date       |
      | Interview      | 2024-30-08 |
    And click on mark interview passed and Save
    And click on offer job and Save
    Then click on Hire and Save
    And should see the information is correct

    Examples:
      | firstName | lastName | vacancy               | email           | contactNumber | keywords |
      | Yutha     | Lopez    | Payroll Administrator | email@gmail.com | 3001234567    | work     |
      | Diana     | Lopez    | Payroll Administrator | email@gmail.com | 3001234567    | work     |