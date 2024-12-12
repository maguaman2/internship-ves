package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.*

@Entity
@Table(name = "academic_tutor")
class AcademicTutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "full_name", nullable = false)
    var fullName: String? = null

    @Column(name = "phone", length = 15)
    var phone: String? = null

    @Column(name = "email", length = 50)
    var email: String? = null

    @Column(name = "career_id")
    var careerId: Int? = null
}