package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.response.SuccessResponse
import ec.edu.sudamericano.internship_ves.service.EvaluationViewService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/evaluation-view")
class EvaluationViewController {

    @Autowired
    lateinit var evaluationViewService: EvaluationViewService

    // Obtener todos los registros de la vista
    @GetMapping
    fun getAllEvaluationView(): ResponseEntity<*> {
        val response = evaluationViewService.getAllEvaluationView()
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    // Obtener un registro específico de la vista por ID de evaluación
    @GetMapping("/{id}")
    fun getEvaluationViewById(@PathVariable id: Long): ResponseEntity<*> {
        val response = evaluationViewService.getEvaluationViewById(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }
}
