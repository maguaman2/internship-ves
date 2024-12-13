import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import ec.edu.sudamericano.internship_ves.dto.StudentDto
import ec.edu.sudamericano.internship_ves.service.StudentService
import ec.edu.sudamericano.internship_ves.response.SuccessResponse

@RestController
@RequestMapping("/students")
class StudentController(private val studentService: StudentService) {

    @GetMapping
    fun getAllStudents(): ResponseEntity<SuccessResponse> {
        val response = studentService.findAll()
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @GetMapping("/{id}")
    fun getStudent(@PathVariable id: Long): ResponseEntity<SuccessResponse> {
        val response = studentService.findById(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @PostMapping
    fun createStudent(@RequestBody dto: StudentDto): ResponseEntity<SuccessResponse> {
        val response = studentService.save(dto)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: Long, @RequestBody dto: StudentDto): ResponseEntity<SuccessResponse> {
        val response = studentService.update(id, dto)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<SuccessResponse> {
        val response = studentService.delete(id)
        return ResponseEntity.ok(SuccessResponse(data = response))
    }
}