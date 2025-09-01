package com.biblioteca.bibliotecacrud.service;

import com.biblioteca.bibliotecacrud.entity.Libro;
import com.biblioteca.bibliotecacrud.repository.ILibroRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private ILibroRepo repo;

    public List<Libro> Listar() {
        return repo.findAll();
    }

    public Libro guardar(Libro libro){
        return repo.save(libro);
    }

    public Libro actualizar(Long id, Libro libroBody){
    Optional<Libro> libro = repo.findById(id);

    Libro libroDb = libro.get();

    if(libro.isPresent()) {
    libroDb.setTitulo(libroBody.getTitulo());
    libroDb.setNombresAutor(libroBody.getNombresAutor());
    libroDb.setAnioPublicacion(libroBody.getAnioPublicacion());
    libroDb.setDisponible(libroBody.getDisponible());
    return repo.save(libroDb);
    }
        return repo.save(libroBody);
    }

    public Optional<Libro> obtenerUno(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public List<Libro> guardarTodo(ArrayList<Libro> libros) {

        return repo.saveAll(libros);
    }

}
