package com.gustavo.usuario_ms.dto;

import com.gustavo.usuario_ms.model.UsuarioEstadoEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record ActualizarUsuarioDto(
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        String nombre,

        @Email(message = "El formato del email no es válido")
        String email,

        UsuarioEstadoEnum estado,

        Set<Long> rolesIds
) {
}
