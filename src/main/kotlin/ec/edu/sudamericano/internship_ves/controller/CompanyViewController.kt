package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.entity.CompanyView
import ec.edu.sudamericano.internship_ves.response.SuccessResponse
import ec.edu.sudamericano.internship_ves.service.CompanyViewService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/company")
class CompanyViewController(private val companyViewService: CompanyViewService) {

    @GetMapping("/company")
    fun getAllCompanies(): ResponseEntity<SuccessResponse> {
        val response = companyViewService.findAll()
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @GetMapping("/company/{id}")
    fun getCompanyById(@PathVariable id: Long): ResponseEntity<SuccessResponse> {
        val response = companyViewService.findById(id)
        return if (response != null) {
            ResponseEntity.ok(SuccessResponse(data = response))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/company")
    fun createCompany(@RequestBody @Valid companyView: CompanyView): ResponseEntity<SuccessResponse> {
        val response = companyViewService.createCompany(companyView)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }
}
