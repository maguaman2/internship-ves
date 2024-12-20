package ec.edu.sudamericano.internship_ves.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.PastOrPresent
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

class PracticeViewDTO {

    @field:NotNull(message = "El ID de la práctica no puede ser nulo")
    var practiceId: Long? = null

    @field:NotBlank(message = "El semestre no puede estar vacío")
    var semester: String? = null

    @field:NotBlank(message = "El término no puede estar vacío")
    var term: String? = null

    @field:NotNull(message = "La fecha de inicio no puede ser nula")
    @field:PastOrPresent(message = "La fecha de inicio no puede ser una fecha futura")
    var startDate: LocalDate? = null

    @field:NotNull(message = "La fecha de fin no puede ser nula")
    @field:FutureOrPresent(message = "La fecha de fin debe ser hoy o una fecha futura")
    var endDate: LocalDate? = null

    @field:FutureOrPresent(message = "La fecha de entrega debe ser hoy o una fecha futura")
    var deliveryDate: LocalDate? = null

    @field:NotNull(message = "El ID del estudiante no puede ser nulo")
    var studentId: Long? = null

    @field:NotBlank(message = "El nombre del estudiante no puede estar vacío")
    var studentFirstName: String? = null

    @field:NotBlank(message = "El apellido del estudiante no puede estar vacío")
    var studentLastName: String? = null

    @field:NotBlank(message = "El email del estudiante no puede estar vacío")
    @field:Email(message = "El email del estudiante debe ser válido")
    var studentEmail: String? = null
}
