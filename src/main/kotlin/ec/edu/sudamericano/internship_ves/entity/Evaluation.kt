package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull


@Entity
@Table(name = "evaluation")
data class Evaluation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val careerName: String? = null,

    @Column(nullable = false)
    val category: String,

    @Column(nullable = false)
    val grade: Double,

    @Column(nullable = false)
    val practice_id: Int,

    )
