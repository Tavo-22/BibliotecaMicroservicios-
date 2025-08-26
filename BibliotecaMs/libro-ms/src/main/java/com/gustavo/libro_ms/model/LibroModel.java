package com.gustavo.libro_ms.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "libros")
public class LibroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorModel autorModel;

    @Column(unique = true)
    private String isbn; //numero identificado de estandar internacional

    private int copiasDisponibles = 0;

    @ManyToMany
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<CategoriaModel> categoria;

    public LibroModel() {
    }

    public LibroModel(String titulo, String isbn, int copiasDispoinbles){
        this.titulo = titulo;
        this.isbn = isbn;
        this.copiasDisponibles = copiasDispoinbles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public AutorModel getAutorModel() {
        return autorModel;
    }

    public void setAutorModel(AutorModel autorModel) {
        this.autorModel = autorModel;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

    public Set<CategoriaModel> getCategoria() {
        return categoria;
    }

    public void setCategoria(Set<CategoriaModel> categoria) {
        this.categoria = categoria;
    }
}
