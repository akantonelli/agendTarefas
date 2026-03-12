package com.akantonelli.agendTarefas.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "ddd", length = 3)
    private String ddd;

    @Column (name = "numero", length = 10)
    private String numero;

}
