package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.EvaluationDto
import ec.edu.sudamericano.internship_ves.response.SuccessResponse
import ec.edu.sudamericano.internship_ves.service.EvaluationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/evaluations")
class EvaluationController() {
    @Autowired
    lateinit var evaluationService: EvaluationService

    @GetMapping
    fun getAllEvaluations(): ResponseEntity<*> {
        val response = evaluationService.getAllEvaluations()
        return ResponseEntity.ok(SuccessResponse(data=response))
    }

    @GetMapping("/{id}")
    fun getEvaluationById(@PathVariable id: Long): ResponseEntity<*> {
        val response = evaluationService.getEvaluationById(id)
        return ResponseEntity.ok(SuccessResponse(data=response))
    }

    @PostMapping
    fun createEvaluation(@RequestBody evaluationDto: EvaluationDto): ResponseEntity<*> {
        val response = evaluationService.createEvaluation(evaluationDto)
        return ResponseEntity.ok(SuccessResponse(data=response))
    }

    @PutMapping("/{id}")
    fun updateEvaluation(@PathVariable id: Long, @RequestBody evaluationDto: EvaluationDto): ResponseEntity<*> {
        val response = evaluationService.updateEvaluation(
            id,
            evaluation = TODO()
        )
        return ResponseEntity.ok(SuccessResponse(data=response))
    }

    @DeleteMapping("/{id}")
    fun deleteEvaluation(@PathVariable id: Long): ResponseEntity<*> {
        val response = evaluationService.deleteEvaluation(id)
        return ResponseEntity.ok(SuccessResponse(data=response))
    }
}
