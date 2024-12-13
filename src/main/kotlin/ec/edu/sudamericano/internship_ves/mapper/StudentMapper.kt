package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.StudentDto
import ec.edu.sudamericano.internship_ves.entity.Student

object StudentMapper {
    fun toDto(student: Student): StudentDto {
        return StudentDto().apply {
            id = student.id
            firstName = student.firstName
            nui = student.nui
            lastName = student.lastName
            photoUrl = student.photoUrl
            email = student.email
            careerId = student.careerId
        }
    }
    fun toEntity(studentDto: StudentDto): Student {
        return Student(
            id = studentDto.id ?: 0,
            firstName = studentDto.firstName ?: "",
            nui = studentDto.nui ?: "",
            lastName = studentDto.lastName ?: "",
            photoUrl = studentDto.photoUrl,
            email = studentDto.email ?: "",
            careerId = studentDto.careerId ?: 0
        )
    }
}