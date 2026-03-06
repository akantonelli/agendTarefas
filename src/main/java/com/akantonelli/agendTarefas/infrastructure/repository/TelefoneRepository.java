package com.akantonelli.agendTarefas.infrastructure.repository;

import com.akantonelli.agendTarefas.infrastructure.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone,Long> {
}
