package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.AcademicTutorDto
import ec.edu.sudamericano.internship_ves.entity.AcademicTutor
import ec.edu.sudamericano.internship_ves.mapper.AcademicTutorMapper
import ec.edu.sudamericano.internship_ves.repository.AcademicTutorRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AcademicTutorService (
    private val academicTutorRepository : AcademicTutorRepository,
    private val academicTutorMapper: AcademicTutorMapper
){
    fun findAll(): List<AcademicTutorDto> {
        return academicTutorRepository.findAll()
            .stream()
            .map { tutor -> academicTutorMapper.toDto(tutor) }
            .collect(Collectors.toList())
    }

    fun findById(id: Long): AcademicTutorDto? {
        return academicTutorRepository.findById(id)
            .map { tutor -> academicTutorMapper.toDto(tutor) }
            .orElse(null)
    }

    fun create(dto: AcademicTutorDto): AcademicTutorDto {
        val academicTutor = academicTutorMapper.toEntity(dto)
        return academicTutorMapper.toDto(academicTutorRepository.save(academicTutor))
    }

    fun update(id: Long, dto: AcademicTutorDto): AcademicTutorDto? {
        if (!academicTutorRepository.existsById(id)) {
            return null
        }
        val academicTutor = academicTutorMapper.toEntity(dto)
        academicTutor.id = id
        return academicTutorMapper.toDto(academicTutorRepository.save(academicTutor))
    }

    fun delete(id: Long): Boolean {
        if (!academicTutorRepository.existsById(id)) {
            return false
        }
        academicTutorRepository.deleteById(id)
        return true
    }

}