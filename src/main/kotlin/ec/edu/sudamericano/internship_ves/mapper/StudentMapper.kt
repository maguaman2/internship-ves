package ec.edu.sudamericano.internship_ves.mapper

import ec.edu.sudamericano.internship_ves.dto.StudentDto
import ec.edu.sudamericano.internship_ves.entity.Student

class StudentMapper {
    fun toDto(student: Student): StudentDto {
        return StudentDto().apply {
            id = student.id
            firstName = student.firstName
            lastName = student.lastName
            nui = student.nui
            photoUrl = student.photoUrl
            email = student.email
            careerId = student.careerId
        }
    }
    fun toEntity(studentDto: StudentDto): Student {
        return Student(
            id = studentDto.id ?: 0,
            firstName = studentDto.firstName ?: "",
            lastName = studentDto.lastName ?: "",
            nui = studentDto.nui ?: "",
            photoUrl = studentDto.photoUrl,
            email = studentDto.email ?: "",
            careerId = studentDto.careerId ?: 0
        )
    }
}