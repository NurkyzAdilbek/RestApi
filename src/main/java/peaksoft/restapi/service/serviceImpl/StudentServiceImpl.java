package peaksoft.restapi.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.restapi.dto.SimpleResponse;
import peaksoft.restapi.dto.StudentRequest;
import peaksoft.restapi.dto.StudentResponse;
import peaksoft.restapi.entity.Student;
import peaksoft.restapi.repository.StudentRepository;
import peaksoft.restapi.service.StudentService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl  implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public SimpleResponse saveStudent(StudentRequest studentRequest) {
        Student student=new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setAge(studentRequest.getAge());
        student.setCreatedDate(LocalDate.now());
        student.setBlocked(false);
         studentRepository.save(student);
         return new SimpleResponse(
                 HttpStatus.OK,
                 "Student with id "+student.getId() +" is saved"
         );
//         return StudentResponse.builder().
//        firstName(studentRequest.getFirstName()).
//                 lastName(studentRequest.getLastName()).
//                 email(studentRequest.getEmail()).
//                 age(studentRequest.getAge()).
//                 createdDate(LocalDate.now()).
//        build();
//        return new StudentResponse(
//                student.getFirstName(),
//                student.getLastName(),
//                student.getEmail(),
//                student.getAge(),
//                student.getCreatedDate()
//        );
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return studentRepository.getStudentById(id).orElseThrow(
                ()->new NoSuchElementException(
                        String.format("Student with id %s not found", id)));

    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAllStudents();
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new NoSuchElementException(
                    String.format("Student with id %s not found", id)
            );
        }
        studentRepository.deleteById(id);

    }

    @Override
    public Student updateStudent(Long id, Student student) {
//        Student oldStudent=getStudentById(id);
//        oldStudent.setFirstName(student.getFirstName());
//        oldStudent.setLastName(student.getLastName());
//        oldStudent.setEmail(student.getEmail());
//        oldStudent.setAge(student.getAge());
      //  studentRepository.save(oldStudent);
        return null;
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}
