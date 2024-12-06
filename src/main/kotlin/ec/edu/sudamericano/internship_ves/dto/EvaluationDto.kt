package ec.edu.sudamericano.internship_ves.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size


data class EvaluationDto(
    val id: Long? = null,

    @field:NotBlank(message = "La evaluación del tutor es obligatoria")
    @field:Size(max = 255, message = "La evaluación del tutor no puede superar los 255 caracteres")
    val tutorEvaluation: String,

    @field:NotBlank(message = "La evaluación del estudiante es obligatoria")
    @field:Size(max = 255, message = "La evaluación del estudiante no puede superar los 255 caracteres")
    val studentEvaluation: String,

    @field:NotBlank(message = "La evaluación del tutor académico es obligatoria")
    @field:Size(max = 255, message = "La evaluación del tutor académico no puede superar los 255 caracteres")
    val academicTutorEvaluation: String,

    @field:Size(max = 255, message = "El nombre de la carrera no puede superar los 255 caracteres")
    val careerName: String? = null
)
