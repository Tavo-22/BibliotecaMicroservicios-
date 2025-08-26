package com.gustavo.usuario_ms.service;

import com.gustavo.usuario_ms.model.UsuarioEstadoEnum;
import com.gustavo.usuario_ms.model.UsuarioModel;
import com.gustavo.usuario_ms.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Consulta 1: Obtener todos los usuarios
    public List<UsuarioModel> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Consulta 2: Buscar usuario por ID
    public Optional<UsuarioModel> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Consulta 3: Buscar usuario por email
    public Optional<UsuarioModel> obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    // Consulta 4: Buscar usuarios por nombre (ignorando mayúsculas/minúsculas)
    public List<UsuarioModel> obtenerUsuariosPorNombre(String nombre) {
        return usuarioRepository.findByNombreIgnoreCase(nombre);
    }

    // Consulta 5: Buscar usuarios por estado
    public List<UsuarioModel> obtenerUsuariosPorEstado(UsuarioEstadoEnum estado) {
        return usuarioRepository.findByEstado(estado);
    }

    // Consulta 6: Buscar usuarios por nombre que contenga texto (insensible a mayúsculas)
    public List<UsuarioModel> buscarUsuariosPorNombreConteniendo(String texto) {
        return usuarioRepository.findByNombreContainingIgnoreCase(texto);
    }

    // Consulta 7: Buscar usuarios por dominio de email
    public List<UsuarioModel> obtenerUsuariosPorDominioEmail(String dominio) {
        return usuarioRepository.findByEmailEndingWith(dominio);
    }

    // Consulta 8: Verificar si existe usuario por email
    public boolean existeUsuarioConEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    // Consulta 9: Contar usuarios por estado
    public long contarUsuariosPorEstado(UsuarioEstadoEnum estado) {
        return usuarioRepository.countByEstado(estado);
    }

    // Consulta 10: Guardar usuario (para crear y actualizar)
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    // Consulta 11: Eliminar usuario por ID
    public void eliminarUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}
