package ec.edu.sudamericano.internship_ves.dto

import java.time.LocalDate

data class ActivityDto(
    val id: Int,
    val description: String,
    val createdAt: LocalDate,
    val startTime: LocalDate,
    val endTime: LocalDate,
    val hours: Int?,
    val resources: String?,
    val observation: String?,
    val practiceId: Int
)
