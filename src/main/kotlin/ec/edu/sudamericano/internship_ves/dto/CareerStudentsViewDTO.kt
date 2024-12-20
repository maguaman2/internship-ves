package com.example.project.dto

data class CareerStudentsViewDTO(
    val studentId: Long,
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

