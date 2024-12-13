package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.entity.StudentCompanyTutor
import ec.edu.sudamericano.internship_ves.repository.StudentCompanyTutorRepository
import org.springframework.stereotype.Service

@Service
class StudentCompanyTutorService(private val repository: StudentCompanyTutorRepository) {

    fun getAllStudents(): List<StudentCompanyTutor> = repository.findAll() as List<StudentCompanyTutor>

    fun saveStudent(student: StudentCompanyTutor): StudentCompanyTutor = repository.save(student)
}
