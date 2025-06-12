package pe.company.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "instructores")
public class Instructor implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer instructorId;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private Double salario;

    public Instructor(){}

    public Instructor(Integer instructorId, String nombre, String apellido, Double salario) {
        this.instructorId = instructorId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
