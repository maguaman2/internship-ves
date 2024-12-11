package ec.edu.sudamericano.internship_ves.controller


import ec.edu.sudamericano.internship_ves.dto.CompanyDto
import ec.edu.sudamericano.internship_ves.service.CompanyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/company")
class CompanyController(private val companyService: CompanyService) {

    @GetMapping
    fun getAllCompanies(): ResponseEntity<List<CompanyDto>> {
        return ResponseEntity.ok(companyService.findAll())
    }

    @GetMapping("/{id}")
    fun getCompanyById(@PathVariable id: Long): ResponseEntity<CompanyDto> {
        val dto = companyService.findById(id)
        return if (dto != null) ResponseEntity.ok(dto) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createCompany(@RequestBody dto: CompanyDto): ResponseEntity<CompanyDto> {
        return ResponseEntity.ok(companyService.create(dto))
    }

    @PutMapping("/{id}")
    fun updateCompany(@PathVariable id: Long, @RequestBody dto: CompanyDto): ResponseEntity<CompanyDto> {
        val updated = companyService.update(id, dto)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCompany(@PathVariable id: Long): ResponseEntity<Void> {
        return if (companyService.delete(id)) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
    }
}
