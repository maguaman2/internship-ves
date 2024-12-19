package ec.edu.sudamericano.internship_ves.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class EvaluationDto(
    val id: Long? = null,

    @field:Size(max = 255, message = "El nombre de la carrera no puede superar los 255 caracteres")
    val careerName: String? = null,

    @field:NotBlank(message = "La categoría es obligatoria")
    @field:Size(max = 255, message = "La categoría no puede superar los 255 caracteres")
    val category: String,

    @field:NotBlank(message = "La calificación es obligatoria")
    @field:Size(max = 50, message = "La calificación no puede superar los 50 caracteres")
    val grade: Double,

    @field:NotBlank(message = "El identificador de la práctica es obligatorio")
    @field:Size(max = 255, message = "El identificador de la práctica no puede superar los 255 caracteres")
    val practiceId: Int
)
