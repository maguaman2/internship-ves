package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.PracticeActivityViewDTO
import ec.edu.sudamericano.internship_ves.service.PracticeActivityViewService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/practice-activities")
class PracticeActivityViewController(
    private val service: PracticeActivityViewService
) {

    @GetMapping
    fun getAllPracticeActivities(): List<PracticeActivityViewDTO> {
        return service.getAllPracticeActivities()
    }
}
