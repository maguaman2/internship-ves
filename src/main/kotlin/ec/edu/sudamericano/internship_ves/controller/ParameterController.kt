import ec.edu.sudamericano.internship_ves.dto.ParameterDTO
import ec.edu.sudamericano.internship_ves.response.SuccessResponse
import ec.edu.sudamericano.internship_ves.service.ParameterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/parameters")
class ParameterController(private val parameterService: ParameterService) {

    @GetMapping
    fun getAllParameters(): ResponseEntity<*> {
        val response = parameterService.findAll()
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @GetMapping("/{id}")
    fun getParameterById(@PathVariable id: Long): ResponseEntity<*> {
        val response = parameterService.findById(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @PostMapping
    fun createParameter(@RequestBody dto: ParameterDTO): ResponseEntity<*> {
        val response = parameterService.create(dto)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @PutMapping("/{id}")
    fun updateParameter(@PathVariable id: Long, @RequestBody dto: ParameterDTO): ResponseEntity<*> {
        val response = parameterService.update(id, dto)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @DeleteMapping("/{id}")
    fun deleteParameter(@PathVariable id: Long): ResponseEntity<*> {
        val response = parameterService.delete(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }
}

