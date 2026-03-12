package com.akantonelli.agendTarefas.infrastructure.repository;

import com.akantonelli.agendTarefas.infrastructure.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    //Metodo através de scripts para banco de dadps (função JPA Repository)
    boolean existsByEmail(String email);

    Optional<Usuario>findByEmail(String email);

}
