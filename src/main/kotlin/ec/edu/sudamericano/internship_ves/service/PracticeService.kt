package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.PracticeDTO
import ec.edu.sudamericano.internship_ves.entity.Practice
import ec.edu.sudamericano.internship_ves.mapper.PracticeMapper
import ec.edu.sudamericano.internship_ves.repository.PracticeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Function
import java.util.stream.Collectors

@Service
class PracticeService {

    @Autowired
    lateinit var practiceRepository: PracticeRepository

    @Autowired
    lateinit var practiceMapper: PracticeMapper

    fun findAll(): List<PracticeDTO> {
        return practiceRepository.findAll()
            .stream()
            .map { practice: Practice? -> practiceMapper.toDTO(practice!!) }
            .collect(Collectors.toList())
    }

    fun findById(id: Long): PracticeDTO? {
        return practiceRepository.findById(id)
            .map<PracticeDTO?>(Function { practice: Practice? ->
                practiceMapper.toDTO(
                    practice!!
                )
            })
            .orElse(null)
    }

    fun create(dto: PracticeDTO): PracticeDTO {
        val practice = practiceMapper.toEntity(dto)
        return practiceMapper.toDTO(practiceRepository.save(practice))
    }

    fun update(id: Long, dto: PracticeDTO): PracticeDTO? {
        if (!practiceRepository.existsById(id)) {
            return null
        }
        val practice = practiceMapper.toEntity(dto)
        practice.id = id
        return practiceMapper.toDTO(practiceRepository.save(practice))
    }

    fun delete(id: Long): Boolean {
        if (!practiceRepository.existsById(id)) {
            return false
        }
        practiceRepository.deleteById(id)
        return true
    }
}
