package ec.edu.sudamericano.internship_ves.mapper


import ec.edu.sudamericano.internship_ves.dto.PracticeViewDTO
import ec.edu.sudamericano.internship_ves.entity.PracticeView
import org.springframework.stereotype.Component

@Component
class PracticeViewMapper {

    fun toDTO(view: PracticeView): PracticeViewDTO {
        val dto = PracticeViewDTO()
        dto.practiceId = view.practiceId
        dto.semester = view.semester
        dto.term = view.term
        dto.startDate = view.startDate
        dto.endDate = view.endDate
        dto.deliveryDate = view.deliveryDate
        dto.studentId = view.studentId
        dto.studentFirstName = view.studentFirstName
        dto.studentLastName = view.studentLastName
        dto.studentEmail = view.studentEmail
        return dto
    }

    fun toEntity(dto: PracticeViewDTO): PracticeView {
        val view = PracticeView().apply {
            practiceId = dto.practiceId
            semester = dto.semester
            term = dto.term
            startDate = dto.startDate
            endDate = dto.endDate
            deliveryDate = dto.deliveryDate
            studentId = dto.studentId
            studentFirstName = dto.studentFirstName
            studentLastName = dto.studentLastName
            studentEmail = dto.studentEmail
        }
        return view
    }
}
