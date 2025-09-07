package com.biblioteca.bibliotecacrud.controller;

import com.biblioteca.bibliotecacrud.entity.Libro;
import com.biblioteca.bibliotecacrud.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/biblioteca")
public class LibroController {
    private LibroService service;


    // ------------------- METODOS CRUD -------------------

    @GetMapping
    public List<Libro> Listar() {
        return service.Listar();
    }

    @GetMapping("/{id}")
    public Optional<Libro> obtenerUnoPorId(@PathVariable Long id) {
        return service.obtenerUno(id);
    }

    @PostMapping("/crearLibro")
    public ResponseEntity<Libro> guardar(@Validated @RequestBody Libro libro) {
        Libro libroCreado = service.guardar(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(libroCreado);
    }

    @PostMapping("/crearVariosLibros")
    public ResponseEntity<List<Libro>> guardarVarios(@Validated @RequestBody ArrayList<Libro> libros) {
        List<Libro> librosCreados = service.guardarTodo(libros);
        return ResponseEntity.status(HttpStatus.CREATED).body(librosCreados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libroBody) {
        Libro libroUp = service.actualizar(id, libroBody);

        // Si el id existe el service actualiza, si no existe, el service crea.
        // Como el metodo en el service siempre devuelve algo, toca distinguir el caso.
        if (libroUp.getId().equals(id)) {
            return new ResponseEntity<>(libroUp, HttpStatus.OK); //Si existe lo actualiza y mando un 200 para validar que si se actualizo
        } else {
            return new ResponseEntity<>(libroUp, HttpStatus.CREATED); //Si no existe manda un 201 que valida su creacion
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> elimarLibro(@PathVariable Long id) {
        service.eliminar(id);
        //devuelve una respuesta HTTP con código 204 No Content, sin body
        return ResponseEntity.noContent().build();
    }
}
