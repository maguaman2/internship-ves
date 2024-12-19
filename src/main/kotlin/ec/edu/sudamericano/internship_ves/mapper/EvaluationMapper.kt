package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.EvaluationDto
import ec.edu.sudamericano.internship_ves.entity.Evaluation
import org.springframework.stereotype.Component

@Component
object EvaluationMapper {

    fun toDto(evaluation: Evaluation): EvaluationDto {
        return EvaluationDto(
            id = evaluation.id,
            careerName = evaluation.careerName,
            category = evaluation.category,
            grade = evaluation.grade,
            practiceId = evaluation.practice_id
        )
    }

    fun toEntity(dto: EvaluationDto): Evaluation {
        return Evaluation(
            id = dto.id,
            careerName = dto.careerName,
            category = dto.category,
            grade = dto.grade,
            practice_id = dto.practiceId
        )
    }
}
