package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.entity.StudentCompanyTutor
import ec.edu.sudamericano.internship_ves.service.StudentCompanyTutorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/company tutor/students")
class StudentCompanyTutorController(private val service: StudentCompanyTutorService) {

    @GetMapping
    fun getStudents(): List<StudentCompanyTutor> = service.getAllStudents()

    @PostMapping
    fun saveStudent(@RequestBody student: StudentCompanyTutor): StudentCompanyTutor = service.saveStudent(student)
}
