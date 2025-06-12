package pe.company.controller;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.company.model.Instructor;
import pe.company.service.InstructorService;

import java.util.Collection;

@RestController
@RequestMapping
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping("/listar_public")
    public ResponseEntity<?>listarPUBLIC(){
        // Se obtiene la lista de todos los instructores
        Collection<Instructor> itemsInstructor=instructorService.findAll();

        // Si la lista está vacía, se retorna estado 204 (No Content)
        if (itemsInstructor.isEmpty()){
            return new ResponseEntity<>(itemsInstructor, HttpStatus.NO_CONTENT);
        }

        // Si hay datos, se retorna la lista con estado 200 (OK)
        return new ResponseEntity<>(itemsInstructor, HttpStatus.OK);
    }

    // Endpoint privado: solo accesible por usuarios con rol ADMIN (configurado en SecurityConfig)
    @GetMapping("/listar_admin")
    public ResponseEntity<?>listarADMIN(){
        Collection<Instructor>itemsInstructor=instructorService.findAll();
        if (itemsInstructor.isEmpty()){
            return new ResponseEntity<>(itemsInstructor, HttpStatus.NO_CONTENT);
        }return new ResponseEntity<>(itemsInstructor, HttpStatus.OK);
    }

    // Endpoint privado: solo accesible por usuarios con rol USER (configurado en SecurityConfig)
    @GetMapping("/listar_user")
    public ResponseEntity<?>listarUSER(){
        Collection<Instructor> itemsInstructor=instructorService.findAll();
        if (itemsInstructor.isEmpty()){
            return new ResponseEntity<>(itemsInstructor, HttpStatus.NO_CONTENT);
        }return new ResponseEntity<>(itemsInstructor, HttpStatus.OK);
    }
}

