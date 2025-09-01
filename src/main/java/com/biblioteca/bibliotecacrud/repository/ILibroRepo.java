package com.biblioteca.bibliotecacrud.repository;

import com.biblioteca.bibliotecacrud.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibroRepo extends JpaRepository<Libro, Long> {
    //Verifica si hay un libro con el mismo titulo
    boolean existsByLibro(String Libro);
}
