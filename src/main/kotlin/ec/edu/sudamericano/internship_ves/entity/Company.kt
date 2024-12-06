package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val entityName: String,
    val ceo: String,
    val latitude: Double? = null,
    val longitude: Double? = null
)
