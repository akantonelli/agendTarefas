package com.akantonelli.agendTarefas.controller;

import com.akantonelli.agendTarefas.business.UsuarioService;
import com.akantonelli.agendTarefas.business.dto.UsuarioDTO;
import com.akantonelli.agendTarefas.infrastructure.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Recepciona os dados e realiza o processamento da API ("porta de entrada dos dados")
@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvaUsuario (@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));

    }



    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletaUsuarioPorEmail (@PathVariable String email){
        usuarioService.deletaUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }



}
