package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.ActivityDto
import ec.edu.sudamericano.internship_ves.entity.Activity
import ec.edu.sudamericano.internship_ves.mapper.ActivityMapper
import ec.edu.sudamericano.internship_ves.repository.ActivityRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ActivityService(
    private val activityRepository: ActivityRepository,
    private val activityMapper: ActivityMapper
) {
    /**
     * Obtener todas las actividades
     */
    fun getAllActivities(): List<ActivityDto> {
        val activities = activityRepository.findAll()
        return activities.map { activityMapper.toDto(it) }
    }

    /**
     * Obtener una actividad por ID
     */
    fun getActivityById(id: Int): Optional<ActivityDto> {
        val activity = activityRepository.findById(id)
        return activity.map { activityMapper.toDto(it) }
    }

    /**
     * Crear una nueva actividad
     */
    fun createActivity(activityDTO: ActivityDto): ActivityDto {
        val activity = activityMapper.toEntity(activityDTO)
        val savedActivity = activityRepository.save(activity)
        return activityMapper.toDto(savedActivity)
    }
    /**
     * Actualizar una actividad por ID
     */
    fun updateActivity(id: Int): Optional<ActivityDto> {
        val activity = activityRepository.findById(id)
        return activity.map { activityMapper.toDto(it) }
    }
    /**
     * Eliminar una actividad por ID
     */
    fun deleteActivity(id: Int) {
        if (activityRepository.existsById(id)) {
            activityRepository.deleteById(id)
        } else {
            throw IllegalArgumentException("Activity with ID $id not found")
        }

    }
}
