package com.akantonelli.agendTarefas.infrastructure.repository;

import com.akantonelli.agendTarefas.infrastructure.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
