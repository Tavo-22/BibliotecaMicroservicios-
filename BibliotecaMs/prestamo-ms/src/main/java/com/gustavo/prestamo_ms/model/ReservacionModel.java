package com.gustavo.prestamo_ms.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservaciones")
public class ReservacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuarioId", nullable = false)
    private Long usuarioId;

    @Column(name = "libroId", nullable = false)
    private Long libroId;

    private LocalDateTime fechaReservacion;

    @Enumerated(EnumType.STRING)
    private EstadoReservacionEnum estadoReservacionEnum = EstadoReservacionEnum.PENDIENTE;

    public ReservacionModel() {
    }

    public ReservacionModel(Long usuarioId, Long libroId) {
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaReservacion = LocalDateTime.now();
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

    public LocalDateTime getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(LocalDateTime fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public EstadoReservacionEnum getEstadoReservacionEnum() {
        return estadoReservacionEnum;
    }

    public void setEstadoReservacionEnum(EstadoReservacionEnum estadoReservacionEnum) {
        this.estadoReservacionEnum = estadoReservacionEnum;
    }
}
