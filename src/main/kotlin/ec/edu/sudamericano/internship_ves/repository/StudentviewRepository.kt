package ec.edu.sudamericano.internship_ves.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ec.edu.sudamericano.internship_ves.entity.Studentview

@Repository
interface StudentviewRepository : JpaRepository<Studentview, Long> {
}