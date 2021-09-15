package validator

import db.CompanyRead
import models.Company

class CompanyValidator {
  def companyIsValid(company: Company): Boolean = {

    val database_object = new CompanyRead
    val companyExist = database_object.getCompanyByName(company.name)

    val emailValidator = new EmailValidator
    val checkEmail = emailValidator.emailIdIsValid(company.emailId)
    if (checkEmail && companyExist == None)
      return true
    false

  }

}
