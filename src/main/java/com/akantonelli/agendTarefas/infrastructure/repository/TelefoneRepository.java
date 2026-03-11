package com.akantonelli.agendTarefas.infrastructure.repository;

import com.akantonelli.agendTarefas.infrastructure.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone,Long> {
}
