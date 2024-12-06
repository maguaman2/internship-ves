package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.PracticeDTO
import ec.edu.sudamericano.internship_ves.entity.Practice
import ec.edu.sudamericano.internship_ves.mapper.PracticeMapper
import ec.edu.sudamericano.internship_ves.repository.PracticeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.function.Function
import java.util.stream.Collectors

@Service
class PracticeService {

    @Autowired
    lateinit var practiceRepository: PracticeRepository

    @Autowired
    lateinit var practiceMapper: PracticeMapper

    fun findAll(): ResponseEntity<Map<String, Any>> {
        val practices = practiceRepository.findAll()
            .stream()
            .map { practice: Practice? -> practiceMapper.toDTO(practice!!) }
            .collect(Collectors.toList())
        return ResponseEntity.ok(mapOf("status" to "success", "data" to practices))
    }

    fun findById(id: Long): ResponseEntity<Map<String, Any>> {
        val practice = practiceRepository.findById(id)
            .map<PracticeDTO?>(Function { practice: Practice? ->
                practiceMapper.toDTO(
                    practice!!
                )
            })
            .orElse(null)
        return if (practice != null) {
            ResponseEntity.ok(mapOf("status" to "success", "data" to practice))
        } else {
            ResponseEntity.status(404).body(mapOf("status" to "fail", "message" to "Practice not found"))
        }
    }

    fun create(dto: PracticeDTO): ResponseEntity<Map<String, Any>> {
        val practice = practiceMapper.toEntity(dto)
        val savedPractice = practiceRepository.save(practice)
        return ResponseEntity.ok(mapOf("status" to "success", "data" to practiceMapper.toDTO(savedPractice)))
    }

    fun update(id: Long, dto: PracticeDTO): ResponseEntity<Map<String, Any>> {
        if (!practiceRepository.existsById(id)) {
            return ResponseEntity.status(404).body(mapOf("status" to "fail", "message" to "Practice not found"))
        }
        val practice = practiceMapper.toEntity(dto)
        practice.id = id
        val updatedPractice = practiceRepository.save(practice)
        return ResponseEntity.ok(mapOf("status" to "success", "data" to practiceMapper.toDTO(updatedPractice)))
    }

    fun delete(id: Long): ResponseEntity<Map<String, Any>> {
        if (!practiceRepository.existsById(id)) {
            return ResponseEntity.status(404).body(mapOf("status" to "fail", "message" to "Practice not found"))
        }
        practiceRepository.deleteById(id)
        return ResponseEntity.ok(mapOf("status" to "success", "message" to "Practice deleted successfully"))
    }
}
