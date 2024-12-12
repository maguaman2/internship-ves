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
        val dto = practiceService.findById(id)
        return ResponseEntity.ok(SuccessResponse())  // Solo devuelve OK, sin necesidad de 'data' o 'null'
    }

    @PostMapping
    fun createPractice(@RequestBody dto: PracticeDTO): ResponseEntity<Any> {
        return try {
            practiceService.create(dto)
            ResponseEntity.ok(SuccessResponse())  // Solo devuelve OK al crear la práctica
        } catch (ex: Exception) {
            ResponseEntity.ok(SuccessResponse())  // Si ocurre un error, también solo devuelve OK
        }
    }

    @PutMapping("/{id}")
    fun updatePractice(@PathVariable id: Long, @RequestBody dto: PracticeDTO): ResponseEntity<Any> {
        return try {
            val updatedPractice = practiceService.update(id, dto)
            if (updatedPractice != null) {
                ResponseEntity.ok(SuccessResponse())  // Solo devuelve OK si la actualización es exitosa
            } else {
                ResponseEntity.ok(SuccessResponse())  // Si no se encuentra la práctica para actualizar, solo OK
            }
        } catch (ex: Exception) {
            ResponseEntity.ok(SuccessResponse())  // En caso de error, responde solo OK
        }
    }

    @DeleteMapping("/{id}")
    fun deletePractice(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            val deleted = practiceService.delete(id)
            if (deleted) {
                ResponseEntity.ok(SuccessResponse())  // Responde OK si la práctica se eliminó exitosamente
            } else {
                ResponseEntity.ok(SuccessResponse())  // Si no se encuentra la práctica para eliminar, responde solo OK
            }
        } catch (ex: Exception) {
            ResponseEntity.ok(SuccessResponse())  // En caso de error, responde solo OK
        }
    }
    }
