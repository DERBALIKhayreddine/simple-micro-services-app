package tn.home.student.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.home.student.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}