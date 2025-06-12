package pe.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.company.model.Instructor;
import pe.company.repository.InstructorRepository;

import java.util.Collection;
import java.util.List;
@Service
public class InstructorServiceImpl implements InstructorService{
    @Autowired
    private InstructorRepository instructorRepository;
    @Override
    public Collection<Instructor> findAll() {
        return (Collection<Instructor>)instructorRepository.findAll();
    }
}
