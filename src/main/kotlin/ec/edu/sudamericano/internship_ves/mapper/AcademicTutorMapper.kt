package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.AcademicTutorDto
import ec.edu.sudamericano.internship_ves.entity.AcademicTutor
import org.springframework.stereotype.Component

@Component
class AcademicTutorMapper {

    fun toDto(academicTutor: AcademicTutor): AcademicTutorDto {
        val dto = AcademicTutorDto()
        dto.id = academicTutor.id
        dto.fullName = academicTutor.fullName
        dto.phone = academicTutor.phone
        dto.email = academicTutor.email
        dto.careerId = academicTutor.careerId
        return dto
    }

    fun toEntity(dto: AcademicTutorDto): AcademicTutor {
        val academicTutor = AcademicTutor()
        academicTutor.id = dto.id
        academicTutor.fullName = dto.fullName
        academicTutor.phone = dto.phone
        academicTutor.email = dto.email
        academicTutor.careerId = dto.careerId
        return academicTutor
    }
}