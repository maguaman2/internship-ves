package ec.edu.sudamericano.internship_ves.controller

import org.springframework.http.ResponseEntity
import ec.edu.sudamericano.internship_ves.dto.AcademicTutorDto
import ec.edu.sudamericano.internship_ves.response.ErrorResponse
import ec.edu.sudamericano.internship_ves.response.SuccessResponse
import ec.edu.sudamericano.internship_ves.service.AcademicTutorService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/academic-tutor")
class AcademicTutorController {

    @RestController
    @RequestMapping("/api/academic-tutor")
    class AcademicTutorController(private val academicTutorService: AcademicTutorService) {

        @GetMapping
        fun getAllTutors(): ResponseEntity<*> {
            val tutors = academicTutorService.findAll()
            return ResponseEntity.ok(SuccessResponse(data = tutors))
        }

        @GetMapping("/{id}")
        fun getTutorById(@PathVariable id: Long): ResponseEntity<*> {
            val tutor = academicTutorService.findById(id) ?: return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(message = "Tutor not found"))
            return ResponseEntity.ok(SuccessResponse(data = tutor))
        }

        @PostMapping
        fun createTutor(@RequestBody academicTutorDto: AcademicTutorDto): ResponseEntity<*> {
            val createdTutor = academicTutorService.create(academicTutorDto)
            return ResponseEntity.ok(SuccessResponse(data = createdTutor))
        }

        @PutMapping("/{id}")
        fun updateTutor(@PathVariable id: Long, @RequestBody academicTutorDto: AcademicTutorDto): ResponseEntity<*> {
            val updatedTutor = academicTutorService.update(id, academicTutorDto) ?: return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(message = "Tutor not found"))
            return ResponseEntity.ok(SuccessResponse(data = updatedTutor))
        }

        @DeleteMapping("/{id}")
        fun deleteTutor(@PathVariable id: Long): ResponseEntity<Any> {
            if (!academicTutorService.delete(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(message = "Tutor not found"))
            }
            return ResponseEntity.noContent().build()
        }
    }
}