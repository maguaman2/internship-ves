package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.CareerDTO
import ec.edu.sudamericano.internship_ves.service.CareerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/careers")
class CareerController(private val careerService: CareerService) {

    @GetMapping
    fun getAllCareers(): ResponseEntity<List<CareerDTO>> =
        ResponseEntity.ok(careerService.getAllCareers())

    @GetMapping("/{id}")
    fun getCareer(@PathVariable id: Int): ResponseEntity<CareerDTO?> =
        ResponseEntity.ok(careerService.getCareerById(id))

    @PostMapping
    fun createCareer(@RequestBody dto: CareerDTO): ResponseEntity<CareerDTO> =
        ResponseEntity.ok(careerService.createCareer(dto))

    @PutMapping("/{id}")
    fun updateCareer(@PathVariable id: Int, @RequestBody dto: CareerDTO): ResponseEntity<CareerDTO?> =
        ResponseEntity.ok(careerService.updateCareer(id, dto))

    @DeleteMapping("/{id}")
    fun deleteCareer(@PathVariable id: Int): ResponseEntity<Boolean> =
        ResponseEntity.ok(careerService.deleteCareer(id))
}

