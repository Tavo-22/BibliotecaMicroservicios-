package com.gustavo.usuario_ms.dto;

import com.gustavo.usuario_ms.model.RolesModel;
import com.gustavo.usuario_ms.model.UsuarioEstadoEnum;

import java.time.LocalDateTime;
import java.util.Set;

public record UsuarioRespuestaDto(
        Long id,
        String nombre,
        String email,
        UsuarioEstadoEnum estado, // ✅ Ya estaba incluido
        LocalDateTime fechaCreacion,
        Set<RolesModel> roles)
{
    public record RolDto(
            Long id,
            String nombre) {
    }
}

