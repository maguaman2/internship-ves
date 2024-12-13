package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.EvaluationDto
import ec.edu.sudamericano.internship_ves.entity.Evaluation
import ec.edu.sudamericano.internship_ves.mapper.EvaluationMapper
import ec.edu.sudamericano.internship_ves.repository.EvaluationRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class EvaluationService(private val evaluationRepository: EvaluationRepository) {

    fun getAllEvaluations(): List<Evaluation> = evaluationRepository.findAll()

    fun getEvaluationById(id: Long): Optional<Evaluation> = evaluationRepository.findById(id)

    fun createEvaluation(id: Long, evaluationDto: EvaluationDto): Evaluation {
        val evaluation = EvaluationMapper.toEntity(evaluationDto)
        return evaluationRepository.save(evaluation)
    }

    fun updateEvaluation(id: Long, evaluationDto: EvaluationDto): Evaluation {
        val evaluation = EvaluationMapper.toEntity(evaluationDto)
            return evaluationRepository.save(evaluation)
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
