package ec.edu.sudamericano.internship_ves.repository

import ec.edu.sudamericano.internship_ves.entity.PracticeActivityView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PracticeActivityViewRepository : JpaRepository<PracticeActivityView, Int> {

    @Query("SELECT pav FROM PracticeActivityView pav")
    fun findAllFromView(): List<PracticeActivityView>
}
