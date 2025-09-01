package com.biblioteca.bibliotecacrud.repository;

import com.biblioteca.bibliotecacrud.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Integer> {
    boolean existsByLibro(String Libro);
}
