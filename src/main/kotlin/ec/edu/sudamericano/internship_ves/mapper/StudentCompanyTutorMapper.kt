package ec.edu.sudamericano.internship_ves.mapper

import TutorDto
import org.springframework.stereotype.Component
import ec.edu.sudamericano.internship_ves.dto.TutorDto
import ec.edu.sudamericano.internship_ves.entity.Tutor

@Component
class TutorMapper {

    fun toDto(tutor: Tutor): TutorDto {
        return TutorDto(
            id = tutor.id,
            name = tutor.name,
            email = tutor.email,
            expertise = tutor.expertise
        )
    }

    fun toEntity(tutorDto: TutorDto): Tutor {
        return Tutor(
            id = tutorDto.id,
            name = tutorDto.name,
            email = tutorDto.email,
            expertise = tutorDto.expertise
        )
    }
}
