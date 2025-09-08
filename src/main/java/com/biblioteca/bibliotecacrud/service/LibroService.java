package com.biblioteca.bibliotecacrud.service;

import com.biblioteca.bibliotecacrud.entity.Libro;
import com.biblioteca.bibliotecacrud.exception.EntityNotFoundException;
import com.biblioteca.bibliotecacrud.repository.ILibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private ILibroRepo repo;

    public List<Libro> Listar() {
        return repo.findAll();
    }

    public List<Libro> Listar(String nombresAutor) {
        return repo.buscarPorAutor(nombresAutor);
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

    public Libro obtenerUno(Long id) {
        Libro libro = repo.findById(id).orElse(null);
        if (libro == null) {
            throw new EntityNotFoundException("Id no encontrado " + id);
        }
        return libro;
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public List<Libro> guardarTodo(ArrayList<Libro> libros) {

        return repo.saveAll(libros);
    }

}
