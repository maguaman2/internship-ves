package com.example.project.repository

import com.example.project.entity.CareerStudentsViewEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CareerStudentsRepository : JpaRepository<CareerStudentsViewEntity, Long> {
    // Método para obtener estudiantes por ID de carrera
    fun findByCareerId(careerId: Long): List<CareerStudentsViewEntity>
}
