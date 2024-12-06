package ec.edu.sudamericano.internship_ves.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ec.edu.sudamericano.internship_ves.service.StudentService
import ec.edu.sudamericano.internship_ves.entity.Student

@RestController
@RequestMapping("/student")
class StudentController (private val studentService: StudentService) {

    @GetMapping
    fun getStudent(): List<Student> {
        return studentService.findAll()
    }

}