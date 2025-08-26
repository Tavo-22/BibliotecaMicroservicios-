package com.gustavo.libro_ms.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class AutorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String pais;

    @OneToMany(mappedBy = "autorModel", cascade = CascadeType.ALL)
    private List<LibroModel> libroModel;

    public AutorModel() {
    }

    public AutorModel(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<LibroModel> getLibroModel() {
        return libroModel;
    }

    public void setLibroModel(List<LibroModel> libroModel) {
        this.libroModel = libroModel;
    }
}
