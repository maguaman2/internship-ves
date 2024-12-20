package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.PracticeViewDTO
import ec.edu.sudamericano.internship_ves.service.PracticeViewService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/practice-view")
class PracticeViewController {

    @Autowired
    lateinit var practiceViewService: PracticeViewService

    @GetMapping
    fun getAll(): List<PracticeViewDTO> {
        return practiceViewService.findAll()
    }
}
