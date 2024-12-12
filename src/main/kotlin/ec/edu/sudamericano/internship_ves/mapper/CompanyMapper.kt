package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.CompanyDto
import ec.edu.sudamericano.internship_ves.entity.Company
import org.springframework.stereotype.Component

@Component
class CompanyMapper {
    fun toDto(entity: Company): CompanyDto = CompanyDto(
        id = entity.id,
        entityName = entity.entityName,
        ceo = entity.ceo,
        latitude = entity.latitude,
        longitude = entity.longitude
    )

    fun toEntity(dto: CompanyDto): Company = Company(
        id = dto.id ?: 0,
        entityName = dto.entityName,
        ceo = dto.ceo,
        latitude = dto.latitude,
        longitude = dto.longitude
    )
}
