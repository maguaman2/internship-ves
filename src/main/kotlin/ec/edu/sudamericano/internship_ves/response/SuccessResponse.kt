package ec.edu.sudamericano.internship_ves.response


data class SuccessResponse(
    val status: String = "success",
    val data: Any? = null
)