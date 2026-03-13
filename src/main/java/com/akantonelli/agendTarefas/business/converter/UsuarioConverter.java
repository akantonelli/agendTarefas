package com.akantonelli.agendTarefas.business.converter;

import com.akantonelli.agendTarefas.business.dto.EnderecoDTO;
import com.akantonelli.agendTarefas.business.dto.TelefoneDTO;
import com.akantonelli.agendTarefas.business.dto.UsuarioDTO;
import com.akantonelli.agendTarefas.infrastructure.entities.Endereco;
import com.akantonelli.agendTarefas.infrastructure.entities.Telefone;
import com.akantonelli.agendTarefas.infrastructure.entities.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

    //DTO -> Entity
    public Usuario paraUsuario (UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .endereco(paraEndereco(usuarioDTO.getEndereco()))
                .telefones(paraListaTelefone(usuarioDTO.getTelefones()))
                .build();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO){
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefone).toList();
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO){
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .uf(enderecoDTO.getUf())
                .cep(enderecoDTO.getCep())
                .build();
    }

    //Entity -> DTO
    public UsuarioDTO paraUsuarioDTO (Usuario usuario){
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .endereco(paraEnderecoDTO(usuario.getEndereco()))
                .telefones(paraListaTelefoneDTO(usuario.getTelefones()))
                .build();
    }

    public TelefoneDTO paraTelefoneDTO (Telefone telefone){
        return TelefoneDTO.builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO (List<Telefone> telefones){
        return telefones.stream().map(this::paraTelefoneDTO).toList();
    }

    public EnderecoDTO paraEnderecoDTO (Endereco endereco){
        return EnderecoDTO.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .uf(endereco.getUf())
                .cep(endereco.getCep())
                .build();
    }

}

