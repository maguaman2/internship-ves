package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.StudentviewDto
import ec.edu.sudamericano.internship_ves.service.StudentviewService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/studentview")
class StudentviewController {

    @Autowired
    lateinit var studentviewService: StudentviewService

    @GetMapping
    fun getAll(): List<StudentviewDto> {
        return studentviewService.findAll()
    }}
