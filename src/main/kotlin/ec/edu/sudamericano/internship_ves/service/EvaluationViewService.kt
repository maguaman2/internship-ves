package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.repository.EvaluationViewRepository
import ec.edu.sudamericano.internship_ves.entity.EvaluationView
import org.springframework.stereotype.Service

@Service
class EvaluationViewService(private val evaluationViewRepository: EvaluationViewRepository) {

    // Obtener todos los registros de la vista
    fun getAllEvaluationView(): List<EvaluationView> = evaluationViewRepository.findAll()

    // Obtener un registro específico de la vista por ID de evaluación
    fun getEvaluationViewById(id: Long): EvaluationView? = evaluationViewRepository.findById(id).orElse(null)
}
