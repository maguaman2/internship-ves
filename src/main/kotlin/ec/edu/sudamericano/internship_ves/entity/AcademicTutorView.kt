package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "academic_tutor_view")
class AcademicTutorView (

    @Id
    @Column(name = "tutor_id")
    var id: Long = 0,

    @Column(name = "tutor_name")
    var tutorName: String = "",

    @Column(name = "tutor_phone")
    var tutorPhone: String? = null,

    @Column(name = "tutor_email")
    var tutorEmail: String = "",

    @Column(name = "career_description")
    var careerDescription: String = ""
)