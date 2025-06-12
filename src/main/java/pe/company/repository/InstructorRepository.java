package pe.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.company.model.Instructor;
@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {
}