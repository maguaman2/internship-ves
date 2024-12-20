package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.PracticeStudentDto
import ec.edu.sudamericano.internship_ves.entity.PracticeStudentView
import org.springframework.stereotype.Component

@Component
class PracticeStudentMapper {

    fun toDto(practiceStudentView: PracticeStudentView): PracticeStudentDto {
        return PracticeStudentDto(
            practiceId = practiceStudentView.practiceId,
            semester = practiceStudentView.semester,
            term = practiceStudentView.term,
            startDate = practiceStudentView.startDate?.toString(),
            endDate = practiceStudentView.endDate?.toString(),
            deliveryDate = practiceStudentView.deliveryDate?.toString(),
            studentId = practiceStudentView.studentId,
            firstName = practiceStudentView.firstName,
            lastName = practiceStudentView.lastName,
            nui = practiceStudentView.nui,
            email = practiceStudentView.email,
            photoUrl = practiceStudentView.photoUrl,
            careerDescription = practiceStudentView.careerDescription,
            careerInstitution = practiceStudentView.careerInstitution
        )
    }
}
