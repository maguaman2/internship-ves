package ec.edu.sudamericano.internship_ves.repository

import ec.edu.sudamericano.internship_ves.entity.AcademicTutor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AcademicTutorRepository: JpaRepository<AcademicTutor, Long> {
}