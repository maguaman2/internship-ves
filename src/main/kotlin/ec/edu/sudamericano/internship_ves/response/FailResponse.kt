package ec.edu.sudamericano.internship_ves.response

data class FailResponse(
    val status: String = "fail",
    val data: Any? = null
)