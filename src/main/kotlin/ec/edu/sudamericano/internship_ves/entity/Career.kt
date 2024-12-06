package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.*

@Entity
@Table(name = "career")
data class Career(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    var description: String = "",
    @Column(name = "institution_name")
    var institutionName: String = "",
    var cycle: Int = 0
)

