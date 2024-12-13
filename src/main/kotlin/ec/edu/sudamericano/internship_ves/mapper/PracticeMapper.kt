package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.PracticeDTO
import ec.edu.sudamericano.internship_ves.entity.Practice
import org.springframework.stereotype.Component

@Component
class PracticeMapper {
    fun toDTO(practice: Practice): PracticeDTO {
        val dto = PracticeDTO()
        dto.id = practice.id
        dto.semester = practice.semester
        dto.term = practice.term
        dto.startDate = practice.startDate
        dto.endDate = practice.endDate
        dto.deliveryDate = practice.deliveryDate
        dto.studentId = practice.studentId
        dto.companyTutorId = practice.companyTutorId
        return dto
    }

    fun toEntity(dto: PracticeDTO): Practice {
        val practice = Practice().apply {
            id = dto.id
            semester = dto.semester
            term = dto.term
            startDate = dto.startDate
            endDate = dto.endDate
            deliveryDate = dto.deliveryDate
            studentId = dto.studentId
            companyTutorId = dto.companyTutorId
        }

        return practice
    }
}