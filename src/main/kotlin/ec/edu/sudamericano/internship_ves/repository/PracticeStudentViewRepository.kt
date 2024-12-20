package ec.edu.sudamericano.internship_ves.repository

import ec.edu.sudamericano.internship_ves.entity.PracticeStudentView
import org.springframework.data.jpa.repository.JpaRepository

interface PracticeStudentViewRepository : JpaRepository<PracticeStudentView, Long> {
}
