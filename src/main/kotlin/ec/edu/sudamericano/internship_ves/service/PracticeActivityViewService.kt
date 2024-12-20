package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.PracticeActivityViewDTO
import ec.edu.sudamericano.internship_ves.mapper.PracticeActivityViewMapper
import ec.edu.sudamericano.internship_ves.repository.PracticeActivityViewRepository
import org.springframework.stereotype.Service

@Service
class PracticeActivityViewService(
    private val repository: PracticeActivityViewRepository
) {
    fun getAllPracticeActivities(): List<PracticeActivityViewDTO> {
        return repository.findAllFromView().map { PracticeActivityViewMapper.toDTO(it) }
    }
}
