Feature: Validate Recruitment functionality in the web site Orange HRM

  Background:
    Given The "user" open the web site

  @rejected
  Scenario Outline: Validate the Recruitment functionality with status Rejected
    And init session with his credentials username "Admin" and password "admin123"
    And select Recruitment and click on add
    When fill all field required
      | firstName   | lastName   | vacancy   | email   | contactNumber   | keywords   |
      | <firstName> | <lastName> | <vacancy> | <email> | <contactNumber> | <keywords> |
    And click on Reject and Save
    Then should see the status is Rejected

    Examples:
      | firstName | lastName | vacancy               | email           | contactNumber | keywords |
      | Walter    | Rojas    | Payroll Administrator | email@gmail.com | 3001234567    | work     |
      | Fiona     | Rojas    | Payroll Administrator | email@gmail.com | 3001234567    | work     |
