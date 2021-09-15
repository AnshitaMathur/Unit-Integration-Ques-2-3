package db
import models.Company

import scala.collection.immutable.HashMap

class CompanyRead {
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val infosysCompany: Company = Company("Infosys", "infosys@gmail.com", "Noida")
  val companies: HashMap[String, Company] = HashMap("Knoldus" -> knoldusCompany, "Infosys" -> infosysCompany)

  def getCompanyByName(name: String): Option[Company] = companies.get(name)

}
