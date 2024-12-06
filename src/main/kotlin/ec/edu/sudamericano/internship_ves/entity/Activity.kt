package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "activity")
data class Activity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(nullable = false)
    val description: String,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDate,

    @Column(name = "start_time", nullable = false)
    val startTime: LocalDate,

    @Column(name = "end_time", nullable = false)
    val endTime: LocalDate,

    val hours: Int? = null,
    val resources: String? = null,
    val observation: String? = null,

    @Column(name = "practice_id", nullable = false)
    val practiceId: Int
)
