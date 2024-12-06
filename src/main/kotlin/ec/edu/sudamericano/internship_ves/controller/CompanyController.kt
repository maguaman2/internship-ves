package ec.edu.sudamericano.internship_ves.controller

import org.springframework.web.bind.annotation.*
import ec.edu.sudamericano.internship_ves.service.CompanyService
import ec.edu.sudamericano.internship_ves.dto.CompanyDto

@RestController
@RequestMapping("/api/companies")
class CompanyController(private val companyService: CompanyService) {

    @GetMapping
    fun getAllCompanies(): List<CompanyDto> {
        return companyService.getAllCompanies()
    }

    @PostMapping
    fun createCompany(@RequestBody companyDto: CompanyDto): CompanyDto {
        return companyService.createCompany(companyDto)
    }

    @GetMapping("/{id}")
    fun getCompanyById(@PathVariable id: Long): CompanyDto? {
        return companyService.getCompanyById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteCompany(@PathVariable id: Long) {
        companyService.deleteCompany(id)
    }
}
