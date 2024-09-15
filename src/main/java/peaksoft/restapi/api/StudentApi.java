package peaksoft.restapi.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapi.dto.SimpleResponse;
import peaksoft.restapi.dto.StudentRequest;
import peaksoft.restapi.dto.StudentResponse;
import peaksoft.restapi.entity.Student;
import peaksoft.restapi.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentApi {
    private final StudentService studentService;

    @PostMapping
    public SimpleResponse saveStudent(@RequestBody StudentRequest studentRequest){
        return studentService.saveStudent(studentRequest);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable Long id, @RequestBody Student student){
     return    studentService.updateStudent(id, student);
    }

    @GetMapping("/getByEmail")
    public Student getByEmail(@RequestParam String email){
        return studentService.findByEmail(email);
    }
}
