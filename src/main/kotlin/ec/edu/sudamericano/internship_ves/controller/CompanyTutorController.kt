package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.CompanyTutorDTO

import ec.edu.sudamericano.internship_ves.service.CompanyTutorService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/company-tutors")
class CompanyTutorController(private val service: CompanyTutorService) {

    @GetMapping
    fun getAllCompanyTutors(): List<CompanyTutorDTO> = service.getAllCompanyTutors()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCompanyTutor(@RequestBody companyTutorDto: CompanyTutorDTO): CompanyTutorDTO =
        service.saveCompanyTutor(companyTutorDto)
}