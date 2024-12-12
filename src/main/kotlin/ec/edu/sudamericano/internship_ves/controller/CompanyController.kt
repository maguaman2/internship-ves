import ec.edu.sudamericano.internship_ves.dto.CompanyDto
import ec.edu.sudamericano.internship_ves.response.SuccessResponse
import ec.edu.sudamericano.internship_ves.service.CompanyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/ves")

class CompanyController(private val CompanyService: CompanyService) {

    @GetMapping
    fun getAllCompany(): ResponseEntity<Any> {
        val response = CompanyService.findAll()
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @GetMapping("/{id}")
    fun getCompany(@PathVariable id: Long): ResponseEntity<SuccessResponse> {
        val response = CompanyService.findById(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @PostMapping
    fun createCompany(@RequestBody dto: CompanyDto): ResponseEntity<SuccessResponse> {
        val response = CompanyService.create(dto)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @PutMapping("/{id}")
    fun updateCompany(@PathVariable id: Int, @RequestBody dto: CompanyDto): ResponseEntity<SuccessResponse> {
        val response = CompanyService.create( dto)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @DeleteMapping("/{id}")
    fun deleteCompany(@PathVariable id: Long): ResponseEntity<SuccessResponse> {
        val response = CompanyService.delete(id )
        return ResponseEntity.ok(SuccessResponse(data = response))
    }
}
