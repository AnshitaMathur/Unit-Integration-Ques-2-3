package ValidatorTest

import models.Employee
import org.scalatest.funsuite.AnyFunSuite
import validator.EmployeeValidator
class EmployeeValidatorTest extends AnyFunSuite{

  val employeeOneAnshita: Employee = Employee("Mathur", "Anshita", 32,50000, "Intern", "Knoldus", "mathur@gmail.com" )
  val employeeTwoDikshi: Employee = Employee("Mathur", "Dikshi", 26,30000, "Software Trainee", "Infosys", "dikshi@gmail.com" )
  val employeeThreePrachi: Employee = Employee("Shrimali", "Prachi", 43,65000, "Sr. Software Consultant", "TCS", "prachi@gmail.com" )
  val employeeFourAnkita: Employee = Employee("Patwa", "Ankita", 22,25000, "Software Trainee", "Knoldus", "ankita?@gmail.com" )


  test("Checking if Employee- employeeOneAnshita working in Knoldus(company present in Database) is a valid Employee"){
    val expectResult = true
    val result = (new EmployeeValidator).employeeIsValid(employeeOneAnshita)
    assert(expectResult == result)
  }


  test("Checking if Employee- employeeTwoDikshi working in Infosys(company present in Database) is a valid Employee"){

    val expectResult = true
    val result = (new EmployeeValidator).employeeIsValid(employeeTwoDikshi)
    assert(expectResult == result)
  }


  test("Checking if Employee- employeeThreePrachi working in company TCS(company not present in Database) is thus an invalid Employee"){

    val expectResult = false
    val result = (new EmployeeValidator).employeeIsValid(employeeThreePrachi)
    assert(expectResult == result)
  }

  test("Checking if Employee- employeeFourAnkita working in Knoldus(company present in Database) having invalid Email ID is thus an invalid Employee"){
    val expectResult = false
    val result = (new EmployeeValidator).employeeIsValid(employeeFourAnkita)
    assert(expectResult == result)
  }

}
