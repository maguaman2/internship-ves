package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.StudentDto
import org.springframework.stereotype.Service
import ec.edu.sudamericano.internship_ves.repository.StudentRepository
import ec.edu.sudamericano.internship_ves.entity.Student
import ec.edu.sudamericano.internship_ves.mapper.StudentMapper

@Service
class StudentService(private val studentRepository: StudentRepository) {
    fun findAll(): List<Student> {
        return studentRepository.findAll()
    }

    fun findById(id: Long): Student {
        return studentRepository.findById(id).orElseThrow { throw RuntimeException("Student not found") }
    }

    fun save(studentDto: StudentDto): Student {
        val student = StudentMapper.toEntity(studentDto)
        return studentRepository.save(student)
    }

    fun update(id: Long, student: StudentDto) {
        val studentToUpdate = findById(id)

    }
    fun delete(id: Long) {
        studentRepository.deleteById(id)
    }

}