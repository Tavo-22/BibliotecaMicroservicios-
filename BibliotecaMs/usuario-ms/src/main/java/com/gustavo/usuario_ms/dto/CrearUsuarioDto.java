package com.gustavo.usuario_ms.dto;

import com.gustavo.usuario_ms.model.UsuarioEstadoEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CrearUsuarioDto(
        @NotBlank(message = "El nombre es obligatorio")
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        String nombre,

        @NotBlank(message = "El email es obligatorio")
        @Email(message = "El formato del email no es válido")
        String email,

        @NotNull(message = "El estado es obligatorio")
        UsuarioEstadoEnum estado,

        @Size(min = 1, message = "Debe asignar al menos un rol")
        java.util.Set<Long> rolesIds
) {
}
