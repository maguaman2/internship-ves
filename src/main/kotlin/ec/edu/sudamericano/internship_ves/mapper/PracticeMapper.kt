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
        val practice = Practice()
        practice.id = dto.id
        practice.semester = dto.semester
        practice.term = dto.term
        practice.startDate = dto.startDate
        practice.endDate = dto.endDate
        practice.deliveryDate = dto.deliveryDate
        practice.studentId = dto.studentId
        practice.companyTutorId = dto.companyTutorId
        return practice
    }
}