import ec.edu.sudamericano.internship_ves.dto.ParameterDTO
import ec.edu.sudamericano.internship_ves.service.ParameterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/parameters")
class ParameterController(private val parameterService: ParameterService) {

    @get:GetMapping
    val allParameters: ResponseEntity<List<ParameterDTO>>
        get() = ResponseEntity.ok(parameterService.findAll())

    @GetMapping("/{id}")
    fun getParameterById(@PathVariable id: Long): ResponseEntity<ParameterDTO> {
        val dto = parameterService.findById(id)
        return if (dto != null) ResponseEntity.ok(dto) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createParameter(@RequestBody dto: ParameterDTO): ResponseEntity<ParameterDTO> {
        return ResponseEntity.ok(parameterService.create(dto))
    }

    @PutMapping("/{id}")
    fun updateParameter(@PathVariable id: Long, @RequestBody dto: ParameterDTO): ResponseEntity<ParameterDTO> {
        val updated = parameterService.update(id, dto)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteParameter(@PathVariable id: Long): ResponseEntity<Void> {
        return if (parameterService.delete(id)) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
    }
}