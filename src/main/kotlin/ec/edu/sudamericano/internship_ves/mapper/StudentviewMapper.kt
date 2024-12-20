package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.StudentviewDto
import ec.edu.sudamericano.internship_ves.entity.Studentview

object StudentviewMapper {
    fun toDto(studentview: Studentview): StudentviewDto = StudentviewDto(
        studentId = studentview.studentId,
        firstName = studentview.firstName,
        lastName = studentview.lastName,
        studentEmail = studentview.studentEmail,
        careerId = studentview.careerId,
        companyId = studentview.companyId,
        companyName = studentview.companyName,
        companyCeo = studentview.companyCeo
    )

    fun toEntity(studentviewDto: StudentviewDto): Studentview = Studentview(
        studentId = studentviewDto.studentId,
        firstName = studentviewDto.firstName,
        lastName = studentviewDto.lastName,
        studentEmail = studentviewDto.studentEmail,
        careerId = studentviewDto.careerId,
        companyId = studentviewDto.companyId,
        companyName = studentviewDto.companyName,
        companyCeo = studentviewDto.companyCeo
    )
}