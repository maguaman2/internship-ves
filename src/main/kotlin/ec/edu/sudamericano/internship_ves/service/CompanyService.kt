package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.CompanyDto
import ec.edu.sudamericano.internship_ves.mapper.CompanyMapper
import ec.edu.sudamericano.internship_ves.repository.CompanyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CompanyService {

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Autowired
    lateinit var companyMapper: CompanyMapper

    fun findAll(): List<CompanyDto> {
        val companies = companyRepository.findAll()
        return companies.map { companyMapper.toDto(it) }
    }

    fun findById(id: Long): CompanyDto? {
        return companyRepository.findById(id)
            .map { companyMapper.toDto(it) }
            .orElse(null)
    }

    fun create(dto: CompanyDto): CompanyDto {

        if (dto.entityName.isBlank() || dto.ceo.isBlank()) {
            throw IllegalArgumentException("El nombre de la entidad y el CEO no pueden estar vacíos.")
        }

        val company = companyMapper.toEntity(dto)
        val savedCompany = companyRepository.save(company)
        return companyMapper.toDto(savedCompany)
    }

    fun update(id: Long, dto: CompanyDto): CompanyDto? {
        if (!companyRepository.existsById(id)) {
            return null
        }

        if (dto.entityName.isBlank() || dto.ceo.isBlank()) {
            throw IllegalArgumentException("El nombre de la entidad y el CEO no pueden estar vacíos.")
        }

        val company = companyMapper.toEntity(dto).copy(id = id)
        val updatedCompany = companyRepository.save(company)
        return companyMapper.toDto(updatedCompany)
    }

    fun delete(id: Long): Boolean {
        if (!companyRepository.existsById(id)) {
            return false
        }
        companyRepository.deleteById(id)
        return true
    }
}
