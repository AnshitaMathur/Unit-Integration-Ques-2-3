package request

import models.Employee
import validator.EmployeeValidator

class EmployeeImpl (employeeValidator: EmployeeValidator) {

  def createEmployee(employee: Employee): Option[String] = {
    if (employeeValidator.employeeIsValid(employee)) Option(employee.emailId)
    else None
  }
}