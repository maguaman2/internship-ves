package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.ActivityDto
import ec.edu.sudamericano.internship_ves.response.SuccessResponse
import ec.edu.sudamericano.internship_ves.service.ActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/activities")
class ActivityController{

    @Autowired
    lateinit var activityService: ActivityService

    @GetMapping
    fun getAllActivities(): ResponseEntity<SuccessResponse> {
        val response = activityService.getAllActivities()
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @GetMapping("/{id}")
    fun getActivityById(@PathVariable id: Int): ResponseEntity<SuccessResponse> {
        val response = activityService.getActivityById(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @PostMapping
    fun createActivity(@RequestBody dto: ActivityDto): ResponseEntity<SuccessResponse> {
        val response = activityService.createActivity(dto)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }
    @PutMapping("/{id}")
    fun updateActivity(@PathVariable id: Int): ResponseEntity<SuccessResponse> {
        val response = activityService.updateActivity(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @DeleteMapping("/{id}")
    fun deleteActivity(@PathVariable id: Int): ResponseEntity<SuccessResponse> {
        val response = activityService.deleteActivity(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }
}
