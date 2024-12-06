package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.EvaluationDto
import ec.edu.sudamericano.internship_ves.mapper.EvaluationMapper
import ec.edu.sudamericano.internship_ves.service.EvaluationService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/evaluations")
class EvaluationController(
    private val evaluationService: EvaluationService,
    private val evaluationMapper: EvaluationMapper
) {

    @GetMapping
    fun getAllEvaluations(): ResponseEntity<Map<String, Any>> {
        val evaluations = evaluationService.getAllEvaluations().map { evaluationMapper.toDto(it) }
        return ResponseEntity.ok(
            mapOf(
                "status" to "success",
                "data" to mapOf("evaluations" to evaluations)
            )
        )
    }

    @GetMapping("/{id}")
    fun getEvaluationById(@PathVariable id: Long): ResponseEntity<Map<String, Any>> {
        val evaluation = evaluationService.getEvaluationById(id)
        return evaluation.map {
            ResponseEntity.ok(
                mapOf(
                    "status" to "success",
                    "data" to mapOf("evaluation" to evaluationMapper.toDto(it))
                )
            )
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createEvaluation(@Valid @RequestBody evaluationDto: EvaluationDto): ResponseEntity<Map<String, Any>> {
        val evaluation = evaluationMapper.toEntity(evaluationDto)
        val savedEvaluation = evaluationService.createEvaluation(evaluation)
        return ResponseEntity.status(HttpStatus.CREATED).body(
            mapOf(
                "status" to "success",
                "data" to mapOf("evaluation" to evaluationMapper.toDto(savedEvaluation))
            )
        )
    }

    @PutMapping("/{id}")
    fun updateEvaluation(
        @PathVariable id: Long,
        @Valid @RequestBody evaluationDto: EvaluationDto
    ): ResponseEntity<Map<String, Any>> {
        val updatedEvaluation = evaluationService.updateEvaluation(id, evaluationMapper.toEntity(evaluationDto))
        return updatedEvaluation.map {
            ResponseEntity.ok(
                mapOf(
                    "status" to "success",
                    "data" to mapOf("evaluation" to evaluationMapper.toDto(it))
                )
            )
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteEvaluation(@PathVariable id: Long): ResponseEntity<Map<String, Any>> {
        return if (evaluationService.deleteEvaluation(id)) {
            ResponseEntity.ok(
                mapOf(
                    "status" to "success",
                    "data" to mapOf("message" to "Evaluation with id $id deleted successfully")
                )
            )
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
