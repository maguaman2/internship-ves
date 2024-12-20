package ec.edu.sudamericano.internship_ves.repository

import ec.edu.sudamericano.internship_ves.entity.EvaluationView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EvaluationViewRepository : JpaRepository<EvaluationView, Long>
