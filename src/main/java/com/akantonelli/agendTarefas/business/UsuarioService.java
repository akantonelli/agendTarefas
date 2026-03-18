package com.akantonelli.agendTarefas.business;

import com.akantonelli.agendTarefas.business.converter.UsuarioConverter;
import com.akantonelli.agendTarefas.business.dto.UsuarioDTO;
import com.akantonelli.agendTarefas.infrastructure.entities.Usuario;
import com.akantonelli.agendTarefas.infrastructure.exceptions.ConflictException;
import com.akantonelli.agendTarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.akantonelli.agendTarefas.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository; //classe imutável (sem modificação)
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;

    public UsuarioDTO salvaUsuario (UsuarioDTO usuarioDTO){
        try {
            emailExiste(usuarioDTO.getEmail());
            usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
            Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
            usuario = usuarioRepository.save(usuario);
            return usuarioConverter.paraUsuarioDTO(usuario);

        }catch (ConflictException e){
            throw new ConflictException("Email já cadastrado." , e.getCause());
        }

    }

    //Inicia verificação de email existente no banco de dados
    public boolean verificaEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }

    //Inicia Validação do email existente
    public void emailExiste (String email){
        try {
            boolean existe = verificaEmailExistente(email);
            if (existe){
                throw new ConflictException("E-mail já cadastrado! email: " + email);
            }
        } catch (ConflictException e) {
            throw new RuntimeException("E-mail já cadastrado!", e.getCause());
        }
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email){
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Email não encontrado: " + email));

        return usuarioConverter.paraUsuarioDTO(usuario);

    }

    public void deletaUsuarioPorEmail (String email){
        usuarioRepository.deleteByEmail(email);
    }


}
