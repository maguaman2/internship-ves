package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "practice_student_view")
data class PracticeStudentView(
    @Id
    val practiceId: Long,  // Clave primaria, no nullable
    val semester: String? = null,
    val term: String? = null,
    val startDate: LocalDate? = null,
    val endDate: LocalDate? = null,
    val deliveryDate: LocalDate? = null,
    val studentId: Long,  // Relacionado con la tabla 'student'
    val firstName: String? = null,
    val lastName: String? = null,
    val nui: String? = null,
    val email: String? = null,
    val photoUrl: String? = null,
    val careerDescription: String? = null,
    val careerInstitution: String? = null
) {
    // Constructor sin argumentos requerido por JPA
    constructor() : this(
        practiceId = 0L,  // Valor predeterminado para practiceId
        studentId = 0L    // Valor predeterminado para studentId
    )
}
