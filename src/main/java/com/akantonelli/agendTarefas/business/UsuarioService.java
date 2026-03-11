package com.akantonelli.agendTarefas.business;

import com.akantonelli.agendTarefas.infrastructure.entities.Usuario;
import com.akantonelli.agendTarefas.infrastructure.exceptions.ConflictException;
import com.akantonelli.agendTarefas.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository; //classe imutável (sem modificação)

    public Usuario salvaUsuario (Usuario usuario){
        try {
            emailExiste(usuario.getEmail());
            return usuarioRepository.save(usuario);

        }catch (ConflictException e){
            throw new ConflictException("Email já cadastrado." , e.getCause());
        }


    }

    public boolean verificaEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }

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

}
