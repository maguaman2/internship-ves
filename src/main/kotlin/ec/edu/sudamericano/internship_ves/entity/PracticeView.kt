package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.Hibernate
import org.hibernate.annotations.Immutable
import java.time.LocalDate

@Entity
@Table(name = "practice_view")
@Immutable
data class PracticeView(
    @Id
    @Column(name = "practice_id")
    var practiceId: Long? = null,

    @Column(name = "semester")
    var semester: String? = null,

    @Column(name = "term")
    var term: String? = null,

    @Column(name = "start_date")
    var startDate: LocalDate? = null,

    @Column(name = "end_date")
    var endDate: LocalDate? = null,

    @Column(name = "delivery_date")
    var deliveryDate: LocalDate? = null,

    @Column(name = "student_id")
    var studentId: Long? = null,

    @Column(name = "student_first_name")
    var studentFirstName: String? = null,

    @Column(name = "student_last_name")
    var studentLastName: String? = null,

    @Column(name = "student_email")
    var studentEmail: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PracticeView
        return practiceId == other.practiceId
    }

    override fun hashCode(): Int = practiceId.hashCode()
}
