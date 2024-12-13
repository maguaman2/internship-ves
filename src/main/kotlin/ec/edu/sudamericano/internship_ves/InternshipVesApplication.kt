package ec.edu.sudamericano.internship_ves

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["ec.edu.sudamericano.internship_ves"])
class InternshipVesApplication

fun main(args: Array<String>) {
	runApplication<InternshipVesApplication>(*args)
}
