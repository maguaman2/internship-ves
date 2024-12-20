package ec.edu.sudamericano.internship_ves.service


import ec.edu.sudamericano.internship_ves.dto.PracticeViewDTO
import ec.edu.sudamericano.internship_ves.mapper.PracticeViewMapper
import ec.edu.sudamericano.internship_ves.repository.PracticeViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PracticeViewService {

    @Autowired
    lateinit var practiceViewRepository: PracticeViewRepository

    @Autowired
    lateinit var practiceViewMapper: PracticeViewMapper

    fun findAll(): List<PracticeViewDTO> {
        return practiceViewRepository.findAll()
            .map { practiceViewMapper.toDTO(it) }
    }
}
