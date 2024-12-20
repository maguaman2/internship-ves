package ec.edu.sudamericano.internship_ves.dto

import java.time.LocalDate

data class PracticeActivityViewDTO(
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
