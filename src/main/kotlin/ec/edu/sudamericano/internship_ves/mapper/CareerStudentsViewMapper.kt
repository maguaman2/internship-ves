package com.example.project.mapper

import com.example.project.dto.CareerStudentsViewDTO
import com.example.project.entity.CareerStudentsViewEntity
import org.springframework.stereotype.Component

@Component
class CareerStudentsViewMapper {
    // Convierte la entidad a DTO
    fun toDTO(entity: CareerStudentsViewEntity): CareerStudentsViewDTO {
        return CareerStudentsViewDTO(
            studentId = entity.studentId,
            careerId = entity.careerId,
            careerDescription = entity.careerDescription,
            institutionName = entity.institutionName,
            cycle = entity.cycle,
            firstName = entity.firstName,
            lastName = entity.lastName,
            nui = entity.nui,
            email = entity.email,
            photoUrl = entity.photoUrl
        )
    }
}
