package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "parameter")
class ParameterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "description", nullable = false)
    var description: String? = null

    @Column(name = "valor", nullable = false)
    var valor: BigDecimal? = null

    @Column(name = "evaluation_id", nullable = false)
    var evaluationId: Long? = null
}