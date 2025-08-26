package com.gustavo.usuario_ms.repository;

import com.gustavo.usuario_ms.model.RolesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RolRepository extends JpaRepository<RolesModel, Long> {
    // Buscar rol por nombre exacto
    Optional<RolesModel> findByNombre(String nombre);

    // Verificar si existe un rol por nombre
    boolean existsByNombre(String nombre);

    // Buscar roles por nombre que contenga un texto
    List<RolesModel> findByNombreContainingIgnoreCase(String nombre);
}
