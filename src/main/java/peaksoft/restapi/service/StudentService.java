package peaksoft.restapi.service;

import peaksoft.restapi.dto.SimpleResponse;
import peaksoft.restapi.dto.StudentRequest;
import peaksoft.restapi.dto.StudentResponse;
import peaksoft.restapi.entity.Student;

import java.util.List;

public interface StudentService {
    SimpleResponse saveStudent(StudentRequest studentRequest);
    StudentResponse getStudentById(Long id);
    List<StudentResponse> getAllStudents();
    void deleteStudentById(Long id);
    Student updateStudent(Long id,Student student);
    Student findByEmail(String email);
}
