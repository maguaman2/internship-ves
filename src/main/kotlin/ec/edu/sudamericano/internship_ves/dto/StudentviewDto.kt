package ec.edu.sudamericano.internship_ves.dto

data class StudentviewDto(
    val studentId: Int,
    val firstName: String,
    val lastName: String,
    val studentEmail: String,
    val careerId: Int?,
    val companyId: Int?,
    val companyName: String?,
    val companyCeo: String?
)