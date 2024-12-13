package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class StudentCompanyTutor(
    @Id val id: Long,
    val name: String,
    val age: Int
)
