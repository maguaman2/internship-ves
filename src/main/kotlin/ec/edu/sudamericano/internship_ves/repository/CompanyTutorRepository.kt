package ec.edu.sudamericano.internship_ves.repository

import ec.edu.sudamericano.internship_ves.entity.CompanyTutor
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyTutorRepository : JpaRepository<CompanyTutor, Long>
