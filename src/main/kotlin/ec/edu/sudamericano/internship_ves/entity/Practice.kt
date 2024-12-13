package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "practice")
class Practice(practiceId: Long) {
    // Getters y Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var semester: String? = null
    var term: String? = null

    @Column(name = "start_date", nullable = false)
    var startDate: LocalDate? = null

    @Column(name = "end_date", nullable = false)
    var endDate: LocalDate? = null

    @Column(name = "delivery_date")
    var deliveryDate: LocalDate? = null

    @Column(name = "student_id", nullable = false)
    var studentId: Long? = null

    @Column(name = "company_tutor_id")
    var companyTutorId: Long? = null
}