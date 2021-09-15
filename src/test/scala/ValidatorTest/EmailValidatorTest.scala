package ValidatorTest
import org.scalatest.funsuite.AnyFunSuite
import validator.EmailValidator
class EmailValidatorTest extends AnyFunSuite {

  val emailValidator_object = new EmailValidator
  test("Checking with a valid Email Id") {

    val expectedResult = true
    val result = emailValidator_object.emailIdIsValid("anshitamathur608@gmail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on passing an invalid Email Id without '@'") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("anshitamathur608gmail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on passing an invalid Email Id with special characters in domain name") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("anshitamathur608@g???mail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on passing an invalid Email Id with special characters in recipient's Name") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("anshita???mathur608@gmail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on passing an invalid Email Id with invalid Top Level Domain") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("anshitamathur608@gmail.cam")
    assert(expectedResult == result)
  }
}
