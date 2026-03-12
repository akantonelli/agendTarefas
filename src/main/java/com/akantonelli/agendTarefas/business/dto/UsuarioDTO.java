package com.akantonelli.agendTarefas.business.dto;

import com.akantonelli.agendTarefas.infrastructure.entities.Endereco;
import com.akantonelli.agendTarefas.infrastructure.entities.Telefone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private Endereco endereco;
    private List<Telefone> telefones;

}
