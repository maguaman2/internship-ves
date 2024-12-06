package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.ActivityDto
import ec.edu.sudamericano.internship_ves.service.ActivityService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/activities")
class ActivityController(
    private val activityService: ActivityService
) {
    @GetMapping
    fun getAllActivities(): ResponseEntity<List<ActivityDto>> {
        val activities = activityService.getAllActivities()
        return ResponseEntity.ok(activities)
    }

    @GetMapping("/{id}")
    fun getActivityById(@PathVariable id: Int): ResponseEntity<ActivityDto> {
        val activity = activityService.getActivityById(id)
        return activity.map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createActivity(@RequestBody dto: ActivityDto): ResponseEntity<ActivityDto> {
        val createdActivity = activityService.createActivity(dto)
        return ResponseEntity.ok(createdActivity)
    }

    @DeleteMapping("/{id}")
    fun deleteActivity(@PathVariable id: Int): ResponseEntity<Void> {
        activityService.deleteActivity(id)
        return ResponseEntity.noContent().build()
    }
}
