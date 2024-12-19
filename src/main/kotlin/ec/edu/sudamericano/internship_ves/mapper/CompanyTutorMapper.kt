package ec.edu.sudamericano.internship_ves.mapper

import CompanyTutorDto
import TutorDto
import ec.edu.sudamericano.internship_ves.entity.CompanyTutor
import org.springframework.stereotype.Component
import ec.edu.sudamericano.internship_ves.entity.Tutor

@Component
class CompanyTutorMapper {

    fun toDto(companyTutor: CompanyTutor): CompanyTutorDto {
        return CompanyTutorDto(
            id = companyTutor.id,
            name = companyTutor.name,
            email = companyTutor.email,
            expertise = companyTutor.expertise
        )
    }

    fun toEntity(companyTutorDto: CompanyTutorDto): CompanyTutor {
        return CompanyTutor(
            id = companyTutorDto.id,
            name = companyTutorDto.name,
            email = companyTutorDto.email,
            expertise = companyTutorDto.expertise
        )
    }
}
