package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.PracticeDTO
import ec.edu.sudamericano.internship_ves.service.PracticeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/practices")
class PracticeController(private val practiceService: PracticeService) {
    @get:GetMapping
    val allPractices: ResponseEntity<List<PracticeDTO>>
        get() = ResponseEntity.ok(practiceService.findAll())

    @GetMapping("/{id}")
    fun getPracticeById(@PathVariable id: Long): ResponseEntity<PracticeDTO> {
        val dto = practiceService.findById(id)
        return if (dto != null) ResponseEntity.ok(dto) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createPractice(@RequestBody dto: PracticeDTO): ResponseEntity<PracticeDTO> {
        return ResponseEntity.ok(practiceService.create(dto))
    }

    @PutMapping("/{id}")
    fun updatePractice(@PathVariable id: Long, @RequestBody dto: PracticeDTO): ResponseEntity<PracticeDTO> {
        val updated = practiceService.update(id, dto)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deletePractice(@PathVariable id: Long): ResponseEntity<Void> {
        return if (practiceService.delete(id)) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
    }
}