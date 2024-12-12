package ec.edu.sudamericano.internship_ves.dto

import jakarta.validation.constraints.*
import java.time.LocalDate

class PracticeDTO {

    @field:PositiveOrZero(message = "El ID debe ser un número positivo o cero.")
    var id: Long? = null

    @field:NotBlank(message = "El semestre no puede estar vacío.")
    @field:Size(max = 10, message = "El semestre no puede tener más de 10 caracteres.")
    var semester: String? = null

    @field:NotBlank(message = "El término no puede estar vacío.")
    @field:Pattern(regexp = "^[A-Za-z\\s]+$", message = "El término solo puede contener letras y espacios.")
    var term: String? = null

    @field:NotNull(message = "La fecha de inicio no puede ser nula.")
    @field:PastOrPresent(message = "La fecha de inicio no puede estar en el futuro.")
    var startDate: LocalDate? = null

    @field:NotNull(message = "La fecha de fin no puede ser nula.")
    @field:Future(message = "La fecha de fin debe estar en el futuro.")
    var endDate: LocalDate? = null

    @field:NotNull(message = "La fecha de entrega no puede ser nula.")
    @field:FutureOrPresent(message = "La fecha de entrega debe ser hoy o en el futuro.")
    var deliveryDate: LocalDate? = null

    @field:NotNull(message = "El ID del estudiante no puede ser nulo.")
    @field:Positive(message = "El ID del estudiante debe ser un número positivo.")
    var studentId: Long? = null

    @field:NotNull(message = "El ID del tutor de la empresa no puede ser nulo.")
    @field:Positive(message = "El ID del tutor de la empresa debe ser un número positivo.")
    var companyTutorId: Long? = null
}
