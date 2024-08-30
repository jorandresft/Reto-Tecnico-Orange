Feature: Validate Recruitment functionality in the web site Orange HRM

  Background:
    Given The "user" open the web site

  @rejected
  Scenario: Validate the Recruitment functionality with status Rejected
    And init session with his credentials username "Admin" and password "admin123"
    And select Recruitment and click on add
    When fill all field required
      | firstName | lastName | vacancy               | email           | contactNumber | keywords |
      | Nora      | Rojas    | Payroll Administrator | email@gmail.com | 3001234567    | work     |
    And click on Reject and Save
    Then should see the status is Rejected