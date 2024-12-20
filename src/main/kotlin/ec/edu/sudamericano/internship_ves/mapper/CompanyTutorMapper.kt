package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.CompanyTutorDTO

import ec.edu.sudamericano.internship_ves.entity.CompanyTutor
import org.springframework.stereotype.Component

@Component
class CompanyTutorMapper {

    fun toDto(companyTutor: CompanyTutor): CompanyTutorDTO {
        val dto = CompanyTutorDTO(
            id = companyTutor.id,
            name = companyTutor.name,
            email = companyTutor.email,
            expertise = companyTutor.expertise
        )
        return dto
    }

    fun toEntity(companyTutorDto: CompanyTutorDTO): CompanyTutor {
        val companyTutor = CompanyTutor(
            id = companyTutorDto.id ?: 0,
            name = companyTutorDto.name,
            email = companyTutorDto.email,
            expertise = companyTutorDto.expertise
        )
        return companyTutor
    }
}
