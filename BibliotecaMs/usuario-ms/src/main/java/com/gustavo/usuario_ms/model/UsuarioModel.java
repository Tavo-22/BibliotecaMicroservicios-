package com.gustavo.usuario_ms.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private UsuarioEstadoEnum usuarioEstadoEnum;

    //Relacion y tabla flotante
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "nombre_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<RolesModel> rolesModel;

    public UsuarioModel() {
    }

    public UsuarioModel(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RolesModel> getRolesModel() {
        return rolesModel;
    }

    public void setRolesModel(Set<RolesModel> rolesModel) {
        this.rolesModel = rolesModel;
    }

    public UsuarioEstadoEnum getUsuarioEstadoEnum() {
        return usuarioEstadoEnum;
    }

    public void setUsuarioEstadoEnum(UsuarioEstadoEnum usuarioEstadoEnum) {
        this.usuarioEstadoEnum = usuarioEstadoEnum;
    }
}
