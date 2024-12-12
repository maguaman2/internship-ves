package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.CompanyDto
import ec.edu.sudamericano.internship_ves.entity.Company
import ec.edu.sudamericano.internship_ves.mapper.CompanyMapper
import ec.edu.sudamericano.internship_ves.repository.CompanyRepository


import org.springframework.stereotype.Service

@Service
class CompanyService(
    private val companyRepository: CompanyRepository,
    private val companyMapper: CompanyMapper
) {

    // Obtener todas las compañías
    fun findAll(): List<CompanyDto> {
        val companies = companyRepository.findAll()
        return companies.map { companyMapper.toDto(it) }
    }

    // Buscar compañía por ID
    fun findById(id: Long): CompanyDto? {
        val company = companyRepository.findById(id)
        return company.map { companyMapper.toDto(it) }.orElse(null) // Devuelve el DTO si existe
    }

    // Crear una nueva compañía
    fun create(dto: CompanyDto): CompanyDto {
        val company = companyMapper.toEntity(dto) // Convierte el DTO a entidad
        val savedCompany = companyRepository.save(company) // Guarda la entidad en la BD
        return companyMapper.toDto(savedCompany) // Convierte la entidad guardada a DTO
    }

    // Actualizar una compañía existente
    fun update(id: Long, dto: CompanyDto): CompanyDto? {
        // Verifica si la compañía existe
        if (!companyRepository.existsById(id)) {
            return null
        }

        // Convierte el DTO a entidad y asigna el ID
        val company = companyMapper.toEntity(dto).copy(id = id)
        val updatedCompany = companyRepository.save(company) // Guarda los cambios
        return companyMapper.toDto(updatedCompany) // Convierte la entidad actualizada a DTO
    }

    // Eliminar una compañía por ID
    fun delete(id: Long): Boolean {
        if (!companyRepository.existsById(id)) {
            return false // Devuelve falso si no existe
        }
        companyRepository.deleteById(id) // Elimina la compañía
        return true // Devuelve verdadero si se elimina correctamente
    }
}
