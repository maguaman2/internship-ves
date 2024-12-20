package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.PracticeActivityViewDTO
import ec.edu.sudamericano.internship_ves.entity.PracticeActivityView

object PracticeActivityViewMapper {
    fun toDTO(view: PracticeActivityView): PracticeActivityViewDTO {
        return PracticeActivityViewDTO(
            practiceId = view.practiceId,
            semester = view.semester,
            term = view.term,
            practiceStartDate = view.practiceStartDate,
            practiceEndDate = view.practiceEndDate,
            activityId = view.activityId,
            activityDescription = view.activityDescription,
            activityCreatedAt = view.activityCreatedAt,
            activityStartTime = view.activityStartTime,
            activityEndTime = view.activityEndTime,
            activityHours = view.activityHours,
            activityResources = view.activityResources,
            activityObservation = view.activityObservation
        )
    }
}
