package com.casamento.casamento_webservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grupo_convite")
public class GrupoConvite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String token;

    @Column(name = "nome_exibicao", nullable = false, length = 150)
    private String nomeExibicao;

    @OneToMany(mappedBy = "grupoConvite")
    private List<Convidado> convidados = new ArrayList<>();
}
