package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.ParameterDTO
import ec.edu.sudamericano.internship_ves.entity.ParameterEntity
import org.springframework.stereotype.Component

@Component
class ParameterMapper {

    fun toDTO(parameter: ParameterEntity): ParameterDTO {
        val dto = ParameterDTO()
        dto.id = parameter.id
        dto.description = parameter.description
        dto.valor = parameter.valor
        dto.evaluationId = parameter.evaluationId
        return dto
    }


    fun toEntity(dto: ParameterDTO): ParameterEntity {
        val parameter = ParameterEntity()
        parameter.id = dto.id
        parameter.description = dto.description
        parameter.valor = dto.valor
        parameter.evaluationId = dto.evaluationId
        return parameter
    }
}
