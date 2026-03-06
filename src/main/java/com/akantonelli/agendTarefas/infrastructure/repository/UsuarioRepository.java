package com.akantonelli.agendTarefas.infrastructure.repository;

import com.akantonelli.agendTarefas.infrastructure.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
