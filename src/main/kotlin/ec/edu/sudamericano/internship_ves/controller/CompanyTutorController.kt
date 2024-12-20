/*package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.entity.CompanyTutor
import ec.edu.sudamericano.internship_ves.service.CompanyTutorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/company-tutor")
class CompanyTutorController(private val service: CompanyTutorService) {

    @GetMapping
    fun getStudents(): List<CompanyTutor> = service.getAllStudents()

    @PostMapping
    fun saveStudent(@RequestBody student: CompanyTutor): CompanyTutor = service.saveStudent(student)
}
*/