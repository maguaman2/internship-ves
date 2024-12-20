package com.example.project.service

import com.example.project.dto.CareerStudentsViewDTO
import com.example.project.mapper.CareerStudentsViewMapper
import com.example.project.repository.CareerStudentsRepository
import org.springframework.stereotype.Service

@Service
class CareerStudentsService(
    private val careerStudentsRepository: CareerStudentsRepository,
    private val careerStudentsViewMapper: CareerStudentsViewMapper // Mapper agregado
) {
    // Obtiene todos los estudiantes y los convierte a DTO
    fun getAllCareerStudents(): List<CareerStudentsViewDTO> {
        return careerStudentsRepository.findAll()
            .map { careerStudentsViewMapper.toDTO(it) } // Uso del mapper
    }

    // Obtiene estudiantes por ID de carrera y los convierte a DTO
    fun getStudentsByCareerId(careerId: Long): List<CareerStudentsViewDTO> {
        return careerStudentsRepository.findByCareerId(careerId)
            .map { careerStudentsViewMapper.toDTO(it) } // Uso del mapper
    }
}

