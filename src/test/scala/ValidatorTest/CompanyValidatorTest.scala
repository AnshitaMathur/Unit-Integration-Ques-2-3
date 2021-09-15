package ValidatorTest


import models.Company
import org.scalatest.funsuite.AnyFunSuite
import validator.CompanyValidator

class CompanyValidatorTest extends AnyFunSuite {

  val companyOne = new Company("Infosys", "infosys@gmail.com", "Noida")
  val companyTwo = new Company("Knoldus", "knoldus@gmail.com", "Noida")
  val companyThree = new Company("Deloitte", "deloittegmail.com", "Delhi")


  test("Check if companyOne is not present in database and is thus a valid entry") {
    val expectedResult = true
    val result = (new CompanyValidator).companyIsValid(companyOne)
    assert(expectedResult == result)
  }

  test("Check if companyTwo is an invalid entry as the company already exists in the database") {
    val expectedResult = false
    val result = (new CompanyValidator).companyIsValid(companyTwo)
    assert(expectedResult == result)
  }

  test("Check if companyThree is not present in database but having invalid email ID without '@'is thus an invalid entry") {
    val expectedResult = false
    val result = (new CompanyValidator).companyIsValid(companyThree)
    assert(expectedResult == result)
  }

}

