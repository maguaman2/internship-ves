package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.CareerDTO
import ec.edu.sudamericano.internship_ves.entity.Career
import ec.edu.sudamericano.internship_ves.mapper.CareerMapper
import ec.edu.sudamericano.internship_ves.repository.CareerRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CareerService(private val careerRepository: CareerRepository, private val careerMapper: CareerMapper) {

    fun getAllCareers(): List<CareerDTO> {
        return careerRepository.findAll()
            .stream()
            .map { career -> careerMapper.toDTO(career) }
            .collect(Collectors.toList())
    }

    fun getCareerById(id: Int): CareerDTO? {
        return careerRepository.findById(id)
            .map { career -> careerMapper.toDTO(career) }
            .orElse(null)
    }

    fun createCareer(dto: CareerDTO): CareerDTO {
        val career = careerMapper.toEntity(dto)
        return careerMapper.toDTO(careerRepository.save(career))
    }

    fun updateCareer(id: Int, dto: CareerDTO): CareerDTO? {
        if (!careerRepository.existsById(id)) return null
        val career = careerMapper.toEntity(dto).apply { this.id = id }
        return careerMapper.toDTO(careerRepository.save(career))
    }

    fun deleteCareer(id: Int): Boolean {
        if (!careerRepository.existsById(id)) return false
        careerRepository.deleteById(id)
        return true
    }
}
