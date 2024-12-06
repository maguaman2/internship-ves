package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.ActivityDto
import ec.edu.sudamericano.internship_ves.entity.Activity
import org.springframework.stereotype.Component

@Component
object ActivityMapper {

    fun toDto(activity: Activity): ActivityDto =
        ActivityDto(
            id = activity.id,
            description = activity.description,
            createdAt = activity.createdAt,
            startTime = activity.startTime,
            endTime = activity.endTime,
            hours = activity.hours,
            resources = activity.resources,
            observation = activity.observation,
            practiceId = activity.practiceId
        )

    fun toEntity(dto: ActivityDto): Activity =
        Activity(
            id = dto.id,
            description = dto.description,
            createdAt = dto.createdAt,
            startTime = dto.startTime,
            endTime = dto.endTime,
            hours = dto.hours,
            resources = dto.resources,
            observation = dto.observation,
            practiceId = dto.practiceId
        )
}
