package ec.edu.sudamericano.internship_ves.service

import org.springframework.stereotype.Service
import ec.edu.sudamericano.internship_ves.repository.StudentRepository
import ec.edu.sudamericano.internship_ves.entity.Student

@Service
class StudentService(private val studentRepository: StudentRepository) {
    fun findAll(): List<Student> {
        return studentRepository.findAll()
    }

    fun findById(id: Long): Student {
        return studentRepository.findById(id).orElseThrow { throw RuntimeException("Student not found") }
    }

    fun save(student: Student): Student {
        return studentRepository.save(student)
    }

    fun update(id: Long, student: Student) {
        val studentToUpdate = findById(id)
    }

}