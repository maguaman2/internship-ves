package ec.edu.sudamericano.internship_ves.controller

import org.springframework.http.ResponseEntity
import ec.edu.sudamericano.internship_ves.dto.AcademicTutorDto
import ec.edu.sudamericano.internship_ves.service.AcademicTutorService
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
class AcademicTutorController (private val academicTutorService: AcademicTutorService) {

    @GetMapping
    fun getAllTutor(): ResponseEntity<List<AcademicTutorDto>> {
        val tutor = academicTutorService.findAll()
        return ResponseEntity.ok(tutor)
    }

    @GetMapping("/{id}")
    fun getTutorById(@PathVariable id: Long): ResponseEntity<AcademicTutorDto> {
        val tutor = academicTutorService.findById(id)
        return if (tutor != null) ResponseEntity.ok(tutor) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createTutor(@RequestBody academicTutorDto: AcademicTutorDto): ResponseEntity<AcademicTutorDto> {
        val createdTutor = academicTutorService.create(academicTutorDto)
        return ResponseEntity.ok(createdTutor)
    }

    @PutMapping("/{id}")
    fun updateTutor(@PathVariable id: Long, @RequestBody academicTutorDto: AcademicTutorDto): ResponseEntity<AcademicTutorDto> {
        val updatedTutor = academicTutorService.update(id, academicTutorDto)
        return if (updatedTutor != null) ResponseEntity.ok(updatedTutor) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteTutor(@PathVariable id: Long): ResponseEntity<Void> {
        return if (academicTutorService.delete(id)) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
    }
}