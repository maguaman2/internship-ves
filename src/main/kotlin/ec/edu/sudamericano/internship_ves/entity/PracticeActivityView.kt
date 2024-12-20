package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Immutable
import java.time.LocalDate

@Entity
@Immutable
@Table(name = "practice_activity_view")
data class PracticeActivityView(
    @Id
    val practiceId: Int,
    val semester: String,
    val term: String,
    val practiceStartDate: LocalDate,
    val practiceEndDate: LocalDate,
    val activityId: Int?,
    val activityDescription: String?,
    val activityCreatedAt: LocalDate?,
    val activityStartTime: LocalDate?,
    val activityEndTime: LocalDate?,
    val activityHours: Int?,
    val activityResources: String?,
    val activityObservation: String?
)
