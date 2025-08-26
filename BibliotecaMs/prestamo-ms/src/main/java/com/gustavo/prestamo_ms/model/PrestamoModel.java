package com.gustavo.prestamo_ms.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
public class PrestamoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuarioId", nullable = false)
    private Long usuarioId;

    @Column(name = "libroId", nullable = false)
    private Long libroId;

    private LocalDate fechaPrestamo;
    private LocalDate fechaPendiente;
    private LocalDate FechaDevuelto;

    @Enumerated(EnumType.STRING)
    private EstadoPrestamoEnum estadoPrestamoEnum = EstadoPrestamoEnum.ACTIVO;

    public PrestamoModel() {
    }

    public PrestamoModel(Long usuarioId, Long libroId, LocalDate fechaPrestamo, LocalDate fechaPendiente) {
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaPendiente = fechaPendiente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaPendiente() {
        return fechaPendiente;
    }

    public void setFechaPendiente(LocalDate fechaPendiente) {
        this.fechaPendiente = fechaPendiente;
    }

    public LocalDate getFechaDevuelto() {
        return FechaDevuelto;
    }

    public void setFechaDevuelto(LocalDate fechaDevuelto) {
        FechaDevuelto = fechaDevuelto;
    }

    public EstadoPrestamoEnum getEstadoPrestamoEnum() {
        return estadoPrestamoEnum;
    }

    public void setEstadoPrestamoEnum(EstadoPrestamoEnum estadoPrestamoEnum) {
        this.estadoPrestamoEnum = estadoPrestamoEnum;
    }
}
