package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.AcademicTutorViewDto
import ec.edu.sudamericano.internship_ves.entity.AcademicTutorView
import org.springframework.stereotype.Component

@Component
class AcademicTutorViewMapper {
    fun toDto(entity: AcademicTutorView): AcademicTutorViewDto {
        return AcademicTutorViewDto(
            tutorName = entity.tutorName,
            tutorPhone = entity.tutorPhone,
            tutorEmail = entity.tutorEmail,
            careerDescription = entity.careerDescription
        )
    }
}