package ec.edu.sudamericano.internship_ves.repository


import ec.edu.sudamericano.internship_ves.entity.PracticeView

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PracticeViewRepository : JpaRepository<PracticeView, Long> {
}
