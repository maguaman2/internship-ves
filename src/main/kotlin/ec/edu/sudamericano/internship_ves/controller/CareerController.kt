package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.CareerDTO
import ec.edu.sudamericano.internship_ves.response.SuccessResponse
import ec.edu.sudamericano.internship_ves.service.CareerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/careers")
class CareerController(private val careerService: CareerService) {

    @GetMapping
    fun getAllCareers(): ResponseEntity<SuccessResponse> {
        val response = careerService.getAllCareers()
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @GetMapping("/{id}")
    fun getCareer(@PathVariable id: Int): ResponseEntity<SuccessResponse> {
        val response = careerService.getCareerById(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @PostMapping
    fun createCareer(@RequestBody dto: CareerDTO): ResponseEntity<SuccessResponse> {
        val response = careerService.createCareer(dto)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @PutMapping("/{id}")
    fun updateCareer(@PathVariable id: Int, @RequestBody dto: CareerDTO): ResponseEntity<SuccessResponse> {
        val response = careerService.updateCareer(id, dto)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @DeleteMapping("/{id}")
    fun deleteCareer(@PathVariable id: Int): ResponseEntity<SuccessResponse> {
        val response = careerService.deleteCareer(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }
}
