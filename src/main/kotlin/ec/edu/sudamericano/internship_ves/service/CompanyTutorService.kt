package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.entity.CompanyTutor
import ec.edu.sudamericano.internship_ves.repository.CompanyTutorRepository
import org.springframework.stereotype.Service

@Service
class CompanyTutorService(private val repository: CompanyTutorRepository) {

    fun getAllStudents(): List<CompanyTutor> = repository.findAll() as List<CompanyTutor>

    fun saveStudent(student: CompanyTutor): CompanyTutor = repository.save(student)
}
