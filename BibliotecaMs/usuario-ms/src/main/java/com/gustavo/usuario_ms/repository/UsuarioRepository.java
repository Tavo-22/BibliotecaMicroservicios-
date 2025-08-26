package com.gustavo.usuario_ms.repository;

import com.gustavo.usuario_ms.model.UsuarioEstadoEnum;
import com.gustavo.usuario_ms.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    // Consulta 1: Buscar usuario por email (coincidencia exacta)
    Optional<UsuarioModel> findByEmail(String email);

    // Consulta 2: Buscar usuarios por nombre (ignorar mayúsculas/minúsculas)
    List<UsuarioModel> findByNombreIgnoreCase(String nombre);

    // Consulta 3: Buscar usuarios por estado (ACTIVO/INACTIVO)
    List<UsuarioModel> findByEstado(UsuarioEstadoEnum estado);

    // Consulta 4: Buscar usuarios por nombre que contenga un texto (insensible a mayúsculas)
    List<UsuarioModel> findByNombreContainingIgnoreCase(String nombre);

    // Consulta 5: Buscar usuarios por email que termine con un dominio específico
    List<UsuarioModel> findByEmailEndingWith(String dominio);

    // Consulta 6: JPQL personalizada - Buscar usuarios inactivos desde una fecha
    @Query("SELECT u FROM UsuarioModel u WHERE u.estado = 'INACTIVO' AND u.fechaCreacion < :fecha")
    List<UsuarioModel> findUsuariosInactivosDesde(@Param("fecha") LocalDateTime fecha);

    // Consulta 7: Verificar si existe un usuario con un email específico
    boolean existsByEmail(String email);

    // Consulta 8: Contar usuarios por estado
    long countByEstado(UsuarioEstadoEnum estado);

    // Consulta 9: Buscar usuarios por rol (usando JOIN con la tabla de roles)
    @Query("SELECT u FROM UsuarioModel u JOIN u.roles r WHERE r.nombre = :nombreRol")
    List<UsuarioModel> findUsuariosPorRol(@Param("nombreRol") String nombreRol);
}
