package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.dto.ParameterDTO
import ec.edu.sudamericano.internship_ves.entity.ParameterEntity
import ec.edu.sudamericano.internship_ves.mapper.ParameterMapper
import ec.edu.sudamericano.internship_ves.repository.ParameterRepository
import org.springframework.stereotype.Service
import java.util.function.Function
import java.util.stream.Collectors

@Service
class ParameterService(
    private val parameterRepository: ParameterRepository,
    private val parameterMapper: ParameterMapper
) {

    fun findAll(): List<ParameterDTO> {
        return parameterRepository.findAll()
            .stream()
            .map { parameter: ParameterEntity -> parameterMapper.toDTO(parameter) }
            .collect(Collectors.toList())
    }


    fun findById(id: Long): ParameterDTO? {
        return parameterRepository.findById(id)
            .map<ParameterDTO?> { parameter: ParameterEntity ->
                parameterMapper.toDTO(parameter)
            }
            .orElse(null)
    }

    fun create(dto: ParameterDTO): ParameterDTO {
        val parameter = parameterMapper.toEntity(dto)
        return parameterMapper.toDTO(parameterRepository.save(parameter))
    }

    fun update(id: Long, dto: ParameterDTO): ParameterDTO? {
        if (!parameterRepository.existsById(id)) {
            return null
        }
        val parameter = parameterMapper.toEntity(dto)
        parameter.id = id
        return parameterMapper.toDTO(parameterRepository.save(parameter))
    }

    fun delete(id: Long): Boolean {
        if (!parameterRepository.existsById(id)) {
            return false
        }
        parameterRepository.deleteById(id)
        return true
    }
}
