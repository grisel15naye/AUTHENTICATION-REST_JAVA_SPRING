package pe.company.service;

import pe.company.model.Instructor;

import java.util.Collection;

public interface InstructorService {
    public abstract Collection<Instructor> findAll();
}
