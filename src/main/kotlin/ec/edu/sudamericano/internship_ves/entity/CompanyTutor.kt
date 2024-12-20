package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.*

@Entity
@Table(name = "company_tutor")
data class CompanyTutor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "email")
    val email: String? = null,

    @Column(name = "expertise")
    val expertise: String? = null
)
