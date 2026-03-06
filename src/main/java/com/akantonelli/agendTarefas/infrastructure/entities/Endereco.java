package com.akantonelli.agendTarefas.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "rua", length = 100)
    private String rua;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "complemento", length = 20)
    private String complemento;

    @Column (name = "cidade", length = 50)
    private String cidade;

    @Column (name = "uf", length = 2)
    private String uf;

    @Column (name = "cep", length = 9)
    private String cep;

}
