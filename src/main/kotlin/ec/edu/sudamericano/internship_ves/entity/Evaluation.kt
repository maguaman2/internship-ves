package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull


@Entity
@Table(name = "evaluation")
data class Evaluation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @NotNull
    @Column(name = "tutor_evaluation")
    val tutorEvaluation: String,

    @NotNull
    @Column(name = "student_evaluation")
    val studentEvaluation: String,

    @NotNull
    @Column(name = "academic_tutor_evaluation")
    val academicTutorEvaluation: String,

    @Column(name = "career_name")
    val careerName: String? = null
)
