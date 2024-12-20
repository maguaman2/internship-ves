package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.CompanyTutorDTO

import ec.edu.sudamericano.internship_ves.mapper.CompanyTutorMapper
import ec.edu.sudamericano.internship_ves.repository.CompanyTutorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CompanyTutorService(
    private val repository: CompanyTutorRepository,
    private val mapper: CompanyTutorMapper
) {

    fun getAllCompanyTutors(): List<CompanyTutorDTO> =
        repository.findAll().map { mapper.toDto(it) }

    fun saveCompanyTutor(companyTutorDto: CompanyTutorDTO): CompanyTutorDTO {
        val companyTutor = mapper.toEntity(companyTutorDto)
        val savedEntity = repository.save(companyTutor)
        return mapper.toDto(savedEntity)
    }
}
