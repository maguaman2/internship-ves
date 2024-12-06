package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.EvaluationDto
import ec.edu.sudamericano.internship_ves.mapper.EvaluationMapper
import ec.edu.sudamericano.internship_ves.service.EvaluationService
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
    fun getAllEvaluations(): List<EvaluationDto> {
        return evaluationService.getAllEvaluations().map { evaluationMapper.toDto(it) }
    }

    @GetMapping("/{id}")
    fun getEvaluationById(@PathVariable id: Long): ResponseEntity<EvaluationDto> {
        val evaluation = evaluationService.getEvaluationById(id)
        return if (evaluation.isPresent) {
            ResponseEntity.ok(evaluationMapper.toDto(evaluation.get()))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createEvaluation(@Valid @RequestBody evaluationDto: EvaluationDto): ResponseEntity<EvaluationDto> {
        val evaluation = evaluationMapper.toEntity(evaluationDto)
        val savedEvaluation = evaluationService.createEvaluation(evaluation)
        return ResponseEntity.status(HttpStatus.CREATED).body(evaluationMapper.toDto(savedEvaluation))
    }

    @PutMapping("/{id}")
    fun updateEvaluation(
        @PathVariable id: Long,
        @Valid @RequestBody evaluationDto: EvaluationDto
    ): ResponseEntity<EvaluationDto> {
        val updatedEvaluation = evaluationService.updateEvaluation(id, evaluationMapper.toEntity(evaluationDto))
        return if (updatedEvaluation.isPresent) {
            ResponseEntity.ok(evaluationMapper.toDto(updatedEvaluation.get()))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteEvaluation(@PathVariable id: Long): ResponseEntity<Void> {
        return if (evaluationService.deleteEvaluation(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}

annotation class Valid
