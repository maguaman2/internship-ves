package ec.edu.sudamericano.internship_ves.entity

import jakarta.persistence.*
import jakarta.validation.constraints.*

@Entity
@Table(name = "company_view")
data class CompanyView(
    @Id
    @Column(name = "company_id")
    val companyId: Long,

    @field:NotBlank(message = "Company name must not be blank")
    @field:Size(max = 255, message = "Company name must not exceed 255 characters")
    @Column(name = "company_name", nullable = false)
    val companyName: String,

    @field:NotBlank(message = "CEO name must not be blank")
    @field:Size(max = 255, message = "CEO name must not exceed 255 characters")
    @Column(name = "company_ceo", nullable = false)
    val companyCeo: String,

    @field:DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @field:DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    @Column(name = "company_latitude", nullable = false)
    val companyLatitude: Double,

    @field:DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @field:DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    @Column(name = "company_longitude", nullable = false)
    val companyLongitude: Double
)
