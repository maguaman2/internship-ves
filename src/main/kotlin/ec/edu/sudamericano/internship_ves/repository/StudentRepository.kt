package ec.edu.sudamericano.internship_ves.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ec.edu.sudamericano.internship_ves.entity.Student

@Repository
interface StudentRepository : JpaRepository<Student, Long> {
}