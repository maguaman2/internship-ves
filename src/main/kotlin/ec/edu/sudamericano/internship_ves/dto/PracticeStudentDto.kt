package ec.edu.sudamericano.internship_ves.dto

data class PracticeStudentDto(
    val practiceId: Long,
    val semester: String?,
    val term: String?,
    val startDate: String?,
    val endDate: String?,
    val deliveryDate: String?,
    val studentId: Long,
    val firstName: String?,
    val lastName: String?,
    val nui: String?,
    val email: String?,
    val photoUrl: String?,
    val careerDescription: String?,
    val careerInstitution: String?
)
