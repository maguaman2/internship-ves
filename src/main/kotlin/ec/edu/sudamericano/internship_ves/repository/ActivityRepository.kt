package ec.edu.sudamericano.internship_ves.repository

import ec.edu.sudamericano.internship_ves.entity.Activity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActivityRepository : JpaRepository<Activity, Int>
