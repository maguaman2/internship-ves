package com.example.project.controller

import com.example.project.dto.CareerStudentsViewDTO
import com.example.project.service.CareerStudentsService
import ec.edu.sudamericano.internship_ves.response.SuccessResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/career-students")
class CareerStudentsController(
    private val careerStudentsService: CareerStudentsService
) {
    // Endpoint para obtener todos los estudiantes
    @GetMapping
    fun getAllCareerStudents(): ResponseEntity<SuccessResponse> {
        val response: List<CareerStudentsViewDTO> = careerStudentsService.getAllCareerStudents()
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    // Endpoint para obtener estudiantes de una carrera específica
    @GetMapping("/career/{careerId}")
    fun getStudentsByCareerId(@PathVariable careerId: Long): ResponseEntity<SuccessResponse> {
        val response: List<CareerStudentsViewDTO> = careerStudentsService.getStudentsByCareerId(careerId)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }
}


