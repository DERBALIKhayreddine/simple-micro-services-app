package tn.home.student.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.home.student.client.AddressFeignClient;
import tn.home.student.entities.Student;
import tn.home.student.exceptions.StudentNotFoundException;
import tn.home.student.repositories.StudentRepository;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressFeignClient addressFeignClient;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    @Override
    public Object getStudentWithAddress(Long id) {
        Student student = getStudentById(id);
        Object address = addressFeignClient.getAddressById(student.getAddressId());
        return new Object() {
            public Student studentDetails = student;
            public Object addressDetails = address;
        };
    }
}