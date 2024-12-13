package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "company")
data class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "entity_name", nullable = false)
    val entityName: String,

    @Column(name = "ceo", nullable = false)
    val ceo: String,

    @Column(name = "latitude")
    val latitude: Double? = null,

    @Column(name = "longitude")
    val longitude: Double? = null
)
