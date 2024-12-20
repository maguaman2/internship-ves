package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Student_view")
data class Studentview(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    var studentId: Int = 0,
    @Column(name = "first_name")
    var firstName: String = "",
    @Column(name = "last_name")
    var lastName: String = "",
    @Column(name = "student_email")
    var studentEmail: String = "",
    @Column(name = "career_id")
    var careerId: Int? = null,
    @Column(name = "company_id")
    var companyId: Int? = null,
    @Column(name = "company_name")
    var companyName: String? = null,
    @Column(name = "company_ceo")
    var companyCeo: String? = null
)