package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "evaluation_view")
data class EvaluationView(
    @Id
    @Column(name = "evaluation_id")
    val evaluationId: Long? = null,

    @Column(name = "career_name", nullable = false)
    val careerName: String? = null,

    @Column(name = "category", nullable = false)
    val category: String,

    @Column(name = "grade", nullable = false)
    val grade: Double,

    @Column(name = "practice_id", nullable = false)
    val practiceId: Int,

    @Column(name = "semester", nullable = false)
    val semester: String,

    @Column(name = "term", nullable = false)
    val term: String,

    @Column(name = "start_date", nullable = false)
    val startDate: LocalDate,

    @Column(name = "end_date", nullable = false)
    val endDate: LocalDate,

    @Column(name = "delivery_date")
    val deliveryDate: LocalDate? = null,

    @Column(name = "student_id", nullable = false)
    val studentId: Int,

    @Column(name = "company_tutor_id")
    val companyTutorId: Int? = null
)
