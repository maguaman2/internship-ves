package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.AcademicTutorViewDto
import ec.edu.sudamericano.internship_ves.entity.AcademicTutorView
import ec.edu.sudamericano.internship_ves.service.AcademicTutorViewService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/tutors")
class AcademicTutorViewController (private val service: AcademicTutorViewService) {
    @GetMapping
    fun getAllTutors() : List<AcademicTutorViewDto> {
        return service.getAllTutors()
    }
}