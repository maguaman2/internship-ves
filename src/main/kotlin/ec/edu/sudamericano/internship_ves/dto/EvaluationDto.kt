package ec.edu.sudamericano.internship_ves.dto

import jakarta.validation.constraints.NotNull

data class EvaluationDto(
    val id: Long? = null,

    @field:NotNull
    val tutorEvaluation: String,

    @field:NotNull
    val studentEvaluation: String,

    @field:NotNull
    val academicTutorEvaluation: String,

    val careerName: String? = null,

    @field:NotNull
    val practiceId: Long
)
