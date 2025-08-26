package com.gustavo.usuario_ms.controller;

import com.gustavo.usuario_ms.dto.ActualizarUsuarioDto;
import com.gustavo.usuario_ms.dto.CrearUsuarioDto;
import com.gustavo.usuario_ms.model.UsuarioEstadoEnum;
import com.gustavo.usuario_ms.model.UsuarioModel;
import com.gustavo.usuario_ms.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // 1. Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> obtenerTodosUsuarios() {
        List<UsuarioModel> usuarios = usuarioService.obtenerTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // 2. Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<UsuarioModel> usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Obtener usuario por email
    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorEmail(@PathVariable String email) {
        Optional<UsuarioModel> usuario = usuarioService.obtenerUsuarioPorEmail(email);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. Buscar usuarios por nombre
    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioModel>> buscarUsuariosPorNombre(
            @RequestParam String nombre) {
        List<UsuarioModel> usuarios = usuarioService.obtenerUsuariosPorNombre(nombre);
        return ResponseEntity.ok(usuarios);
    }

    // 5. Buscar usuarios por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<UsuarioModel>> obtenerUsuariosPorEstado(
            @PathVariable UsuarioEstadoEnum estado) {
        List<UsuarioModel> usuarios = usuarioService.obtenerUsuariosPorEstado(estado);
        return ResponseEntity.ok(usuarios);
    }

    // 6. Verificar si existe email
    @GetMapping("/existe-email/{email}")
    public ResponseEntity<Boolean> existeEmail(@PathVariable String email) {
        boolean existe = usuarioService.existeUsuarioConEmail(email);
        return ResponseEntity.ok(existe);
    }

    // 7. Contar usuarios por estado
    @GetMapping("/contar/{estado}")
    public ResponseEntity<Long> contarUsuariosPorEstado(@PathVariable UsuarioEstadoEnum estado) {
        long cantidad = usuarioService.contarUsuariosPorEstado(estado);
        return ResponseEntity.ok(cantidad);
    }

//    // 8. Crear usuario (POST básico - luego añadiremos DTOs)
//    @PostMapping
//    public ResponseEntity<UsuarioModel> crearUsuario(@Valid @RequestBody CrearUsuarioDto crearDto) {
//        // Convertir DTO a entidad y guardar
//        UsuarioModel usuario = convertirDtoAEntidad(crearDto);
//        UsuarioModel usuarioCreado = usuarioService.guardarUsuario(usuario);
//        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
//    }

    // En UsuarioController.java
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> actualizarUsuario(
            @PathVariable Long id,
            @Valid @RequestBody ActualizarUsuarioDto actualizarDto) {

        Optional<UsuarioModel> usuarioExistente = usuarioService.obtenerUsuarioPorId(id);

        if (usuarioExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        UsuarioModel usuario = usuarioExistente.get();

        // Actualizar solo los campos que vienen en el DTO (si no son nulos)
        if (actualizarDto.nombre() != null) {
            usuario.setNombre(actualizarDto.nombre());
        }

        if (actualizarDto.email() != null) {
            usuario.setEmail(actualizarDto.email());
        }

        if (actualizarDto.estado() != null) {
            usuario.setUsuarioEstadoEnum(actualizarDto.estado());
        }

        // Los roles se manejarían por separado (ver siguiente ejemplo)

        UsuarioModel usuarioActualizado = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // En UsuarioController.java
    @PatchMapping("/{id}/estado")
    public ResponseEntity<UsuarioModel> actualizarEstadoUsuario(
            @PathVariable Long id,
            @RequestParam UsuarioEstadoEnum nuevoEstado) {

        Optional<UsuarioModel> usuarioExistente = usuarioService.obtenerUsuarioPorId(id);

        if (usuarioExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        UsuarioModel usuario = usuarioExistente.get();
        usuario.setUsuarioEstadoEnum(nuevoEstado);

        UsuarioModel usuarioActualizado = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // 9. Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        if (usuarioService.obtenerUsuarioPorId(id).isPresent()) {
            usuarioService.eliminarUsuarioPorId(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
