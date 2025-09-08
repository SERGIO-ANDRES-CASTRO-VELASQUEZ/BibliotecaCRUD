package com.biblioteca.bibliotecacrud.repository;

import com.biblioteca.bibliotecacrud.entity.Libro;
import org.hibernate.mapping.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILibroRepo extends JpaRepository<Libro, Long> {
    //Verifica si hay un libro con el mismo titulo
    @Query("select lb from Libro lb where lower(lb.nombresAutor) like lower(concat('%',:nombresAutor,'%')) ")
    List<Libro> buscarPorAutor(@Param("nombresAutor") String nombresAutor);

}
