package com.example.project.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "career_students")  // Asegúrate de que el nombre de la vista sea correcto
data class CareerStudentsViewEntity(
    @Id
    val studentId: Long,  // Clave primaria en la vista
    val careerId: Long,
    val careerDescription: String,
    val institutionName: String,
    val cycle: Int,
    val firstName: String,
    val lastName: String,
    val nui: String,
    val email: String,
    val photoUrl: String?
)


