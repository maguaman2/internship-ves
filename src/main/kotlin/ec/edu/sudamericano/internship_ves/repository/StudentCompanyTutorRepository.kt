package ec.edu.sudamericano.internship_ves.repository

import ec.edu.sudamericano.internship_ves.entity.StudentCompanyTutor
import org.springframework.data.jpa.repository.JpaRepository

interface StudentCompanyTutorRepository : JpaRepository<StudentCompanyTutor, Long>
