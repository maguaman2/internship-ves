package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.PracticeStudentDto
import ec.edu.sudamericano.internship_ves.mapper.PracticeStudentMapper
import ec.edu.sudamericano.internship_ves.repository.PracticeStudentViewRepository
import org.springframework.stereotype.Service

@Service
class PracticeStudentService(
    private val repository: PracticeStudentViewRepository,
    private val mapper: PracticeStudentMapper
) {
    fun getAllPracticeStudents(): List<PracticeStudentDto> {
        return repository.findAll().map { mapper.toDto(it) }
    }
}
