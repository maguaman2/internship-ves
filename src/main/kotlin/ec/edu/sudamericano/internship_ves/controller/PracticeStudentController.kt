package ec.edu.sudamericano.internship_ves.controller

import ec.edu.sudamericano.internship_ves.dto.PracticeStudentDto
import ec.edu.sudamericano.internship_ves.mapper.PracticeStudentMapper
import ec.edu.sudamericano.internship_ves.response.SuccessResponse
import ec.edu.sudamericano.internship_ves.repository.PracticeStudentViewRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/practice-student")
class PracticeStudentController(
    private val practiceStudentViewRepository: PracticeStudentViewRepository,
    private val practiceStudentMapper: PracticeStudentMapper
) {
    @GetMapping
    fun getPracticeStudents(): ResponseEntity<SuccessResponse> {
        val practiceStudentViews = practiceStudentViewRepository.findAll()
        val practiceStudentDtos = practiceStudentViews.map { practiceStudentMapper.toDto(it) }
        return ResponseEntity.ok(SuccessResponse(data = practiceStudentDtos))
    }
}
