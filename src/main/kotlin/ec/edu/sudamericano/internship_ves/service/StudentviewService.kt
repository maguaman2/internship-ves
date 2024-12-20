package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.StudentviewDto
import ec.edu.sudamericano.internship_ves.mapper.StudentviewMapper
import ec.edu.sudamericano.internship_ves.repository.StudentviewRepository
import org.springframework.stereotype.Service

@Service
class StudentviewService(
    private val studentviewRepository: StudentviewRepository
) {
    fun findAll(): List<StudentviewDto> {
        return studentviewRepository.findAll()
            .map(StudentviewMapper::toDto)
    }

    fun findById(id: Long): StudentviewDto {
        val studentview = studentviewRepository.findById(id)
            .orElseThrow { RuntimeException("Student view with ID $id not found") }
        return StudentviewMapper.toDto(studentview)
    }

    fun create(dto: StudentviewDto): StudentviewDto {
        val studentview = StudentviewMapper.toEntity(dto)
        val savedStudentview = studentviewRepository.save(studentview)
        return StudentviewMapper.toDto(savedStudentview)
    }

    fun update(id: Long, dto: StudentviewDto): StudentviewDto {
        if (!studentviewRepository.existsById(id)) {
            throw RuntimeException("Student view with ID $id not found")
        }
        val updatedStudentview = StudentviewMapper.toEntity(dto).apply { this.studentId = id.toInt() }
        val savedStudentview = studentviewRepository.save(updatedStudentview)
        return StudentviewMapper.toDto(savedStudentview)
    }

    fun delete(id: Long) {
        if (!studentviewRepository.existsById(id)) {
            throw RuntimeException("Student view with ID $id not found")
        }
        studentviewRepository.deleteById(id)
    }
}