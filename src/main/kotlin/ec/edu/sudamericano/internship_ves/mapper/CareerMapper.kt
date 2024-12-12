package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.CareerDTO
import ec.edu.sudamericano.internship_ves.entity.Career
import org.springframework.stereotype.Component

@Component
class CareerMapper {
    fun toDTO(career: Career): CareerDTO {
        return CareerDTO(
            id = career.id,
            description = career.description,
            institutionName = career.institutionName,
            cycle = career.cycle
        )
    }

    fun toEntity(dto: CareerDTO): Career {
        return Career(
            id = dto.id,
            description = dto.description,
            institutionName = dto.institutionName,
            cycle = dto.cycle
        )
    }
}



