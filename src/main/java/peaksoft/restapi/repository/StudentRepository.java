package peaksoft.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.restapi.dto.StudentResponse;
import peaksoft.restapi.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByEmail(String email);


    @Query ("select  new peaksoft.restapi.dto.StudentResponse " +
            "(s.firstName, s.lastName, s.email,s.age,s.createdDate ) from Student s ")
    List<StudentResponse> findAllStudents();


    @Query ("select  new peaksoft.restapi.dto.StudentResponse " +
            "(s.firstName, s.lastName, s.email,s.age,s.createdDate ) from Student s  where s.id=:id")
   Optional< StudentResponse> getStudentById(Long id);

//    concat( s.firstName, s.lastName) biriktirip koiso bolot jany achyp

}
