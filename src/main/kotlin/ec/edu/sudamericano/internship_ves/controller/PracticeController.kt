package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.PracticeDTO
import ec.edu.sudamericano.internship_ves.response.SuccessResponse
import ec.edu.sudamericano.internship_ves.service.PracticeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/practices")
class PracticeController(private val practiceService: PracticeService) {

    @GetMapping
    fun getAllPractices(): ResponseEntity<Any> {
        val practices = practiceService.findAll()
        return ResponseEntity.ok(SuccessResponse(data = practices))
    }

    @GetMapping("/{id}")
    fun getPracticeById(@PathVariable id: Long): ResponseEntity<Any> {
        val response = practiceService.findById(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @PostMapping
    fun createPractice(@RequestBody dto: PracticeDTO): ResponseEntity<Any> {
        val response = practiceService.create(dto)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @PutMapping("/{id}")
    fun updatePractice(@PathVariable id: Long, @RequestBody dto: PracticeDTO): ResponseEntity<Any> {
        val response = practiceService.create(dto)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @DeleteMapping("/{id}")
    fun deletePractice(@PathVariable id: Long): ResponseEntity<Any> {
        val response = practiceService.delete(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }
}