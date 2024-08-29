Feature: Validate Recruitment functionality in the web site Orange HRM

  Background:
    Given The "user" open the web site

  @successful
  Scenario: Validate the Recruitment functionality with status Hired
    And init session with his credentials username "Admin" and password "admin123"
    And select Recruitment and add
    When fill all field required
      | firstName | lastName | vacancy               | email           | contactNumber | keywords |
      | Leo       | Rosi     | Payroll Administrator | email@gmail.com | 3001234567    | work     |
    And schedules the interview
      | interviewTitle | date       |
      | Interview      | 2024-29-08 |
    Then he should see the information is correct