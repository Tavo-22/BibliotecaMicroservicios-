package com.gustavo.usuario_ms.service;

import com.gustavo.usuario_ms.model.RolesModel;
import com.gustavo.usuario_ms.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    // Consulta 1: Obtener todos los roles
    public List<RolesModel> obtenerTodosRoles() {
        return rolRepository.findAll();
    }

    // Consulta 2: Buscar rol por ID
    public Optional<RolesModel> obtenerRolPorId(Long id) {
        return rolRepository.findById(id);
    }

    // Consulta 3: Buscar rol por nombre
    public Optional<RolesModel> obtenerRolPorNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }

    // Consulta 4: Buscar roles por nombre que contenga texto
    public List<RolesModel> buscarRolesPorNombreConteniendo(String texto) {
        return rolRepository.findByNombreContainingIgnoreCase(texto);
    }

    // Consulta 5: Verificar si existe rol por nombre
    public boolean existeRolConNombre(String nombre) {
        return rolRepository.existsByNombre(nombre);
    }

    // Consulta 6: Guardar rol
    public RolesModel guardarRol(RolesModel rol) {
        return rolRepository.save(rol);
    }

    // Consulta 7: Eliminar rol por ID
    public void eliminarRolPorId(Long id) {
        rolRepository.deleteById(id);
    }

//    // Consulta 8: Crear rol si no existe
//    public RolesModel crearRolSiNoExiste(String nombreRol) {
//        return rolesRepository.findByNombre(nombreRol)
//                .orElseGet(() -> {
//                    RolesModel nuevoRol = new RolesModel();
//                    nuevoRol.setNombre(nombreRol);
//                    return rolesRepository.save(nuevoRol);
//                });
//    }

}
