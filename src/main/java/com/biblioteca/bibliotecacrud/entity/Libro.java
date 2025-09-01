package com.biblioteca.bibliotecacrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_libros")

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="titulo_libro", nullable=false, unique=true)
    private String titulo;
    @Column(name="nombre_autor", nullable=false, unique=false, length=70)
    private String nombresAutor;
    @Column(name="Año_publicacion", nullable=false, unique=false, length=4)
    private Integer anioPublicacion;
    @Column(name="Disponible", nullable=false, unique=false)
    private Boolean disponible;
// Constructor vacio

    public Libro() {

    }

// Constructor con paramettros


    public Libro(String titulo, String nombresAutor, Integer anioPublicacion, Boolean disponible) {
        this.titulo = titulo;
        this.nombresAutor = nombresAutor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombresAutor() {
        return nombresAutor;
    }

    public void setNombresAutor(String nombresAutor) {
        this.nombresAutor = nombresAutor;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", nombresAutor='" + nombresAutor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", disponible=" + disponible +
                '}';
    }
}

