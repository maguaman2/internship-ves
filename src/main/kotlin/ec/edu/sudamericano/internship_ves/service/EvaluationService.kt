package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.EvaluationDto
import ec.edu.sudamericano.internship_ves.entity.Evaluation
import ec.edu.sudamericano.internship_ves.repository.EvaluationRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class EvaluationService(private val evaluationRepository: EvaluationRepository) {

    fun getAllEvaluations(): List<Evaluation> = evaluationRepository.findAll()

    fun getEvaluationById(id: Long): Optional<Evaluation> = evaluationRepository.findById(id)

    fun createEvaluation(evaluation: EvaluationDto): Evaluation = evaluationRepository.save(evaluation)

    fun updateEvaluation(id: Long, evaluation: Evaluation): Optional<Evaluation> {
        return if (evaluationRepository.existsById(id)) {
            Optional.of(evaluationRepository.save(evaluation.copy(id = id)))
        } else {
            Optional.empty()
        }
    }

    fun deleteEvaluation(id: Long): Boolean {
        return if (evaluationRepository.existsById(id)) {
            evaluationRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
