Feature: Validate Recruitment functionality in the web site Orange HRM

  Background:
    Given The "user" open the web site

  @successful
  Scenario: Validate the Recruitment functionality with status Hired
    And init session with his credentials username "Admin" and password "admin123"
    And select Recruitment and click on add
    When fill all field required
      | firstName | lastName | vacancy               | email           | contactNumber | keywords |
      | Lia       | Miss     | Payroll Administrator | email@gmail.com | 3001234567    | work     |
    And click on Shortlist and Save
    And click on Schedule Interview and fill all field required
      | interviewTitle | date       |
      | Interview      | 2024-29-08 |
    And click on mark interview passed and Save
    And click on offer job and Save
    Then click on Hire and Save
    And should see the information is correct