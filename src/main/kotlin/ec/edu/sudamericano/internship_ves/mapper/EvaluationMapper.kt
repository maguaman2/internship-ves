package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.EvaluationDto
import ec.edu.sudamericano.internship_ves.entity.Evaluation
import org.springframework.stereotype.Component

@Component
object EvaluationMapper {

    fun toDto(evaluation: Evaluation): EvaluationDto {
        return EvaluationDto(
            id = evaluation.id,
            tutorEvaluation = evaluation.tutorEvaluation,
            studentEvaluation = evaluation.studentEvaluation,
            academicTutorEvaluation = evaluation.academicTutorEvaluation,
            careerName = evaluation.careerName
        )
    }

    fun toEntity(dto: EvaluationDto): Evaluation {
        return Evaluation(
            id = dto.id,
            tutorEvaluation = dto.tutorEvaluation,
            studentEvaluation = dto.studentEvaluation,
            academicTutorEvaluation = dto.academicTutorEvaluation,
            careerName = dto.careerName
        )
    }
}
