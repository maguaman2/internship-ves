package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="tbl_student")
class Student (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val firstName: String,

    @Column(nullable = false)
    val lastName: String,

    @Column(nullable = false, unique = true)
    val nui: String,

    @Column(nullable = true)
    val photoUrl: String? = null,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val careerId: Long
)