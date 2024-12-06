package ec.edu.sudamericano.internship_ves.dto

data class CompanyDto(
    val id: Long?,
    val entityName: String,
    val ceo: String,
    val latitude: Double?,
    val longitude: Double?
)
