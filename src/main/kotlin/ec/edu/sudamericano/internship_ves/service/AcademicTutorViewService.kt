package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.AcademicTutorViewDto
import ec.edu.sudamericano.internship_ves.mapper.AcademicTutorViewMapper
import ec.edu.sudamericano.internship_ves.repository.AcademicTutorViewRepository
import org.springframework.stereotype.Service

@Service
class AcademicTutorViewService (
    private val repository: AcademicTutorViewRepository,
    private val mapper: AcademicTutorViewMapper
) {
    fun getAllTutors(): List<AcademicTutorViewDto> {
        val tutors = repository.findAll()
        return tutors.map { mapper.toDto(it) }
    }
}