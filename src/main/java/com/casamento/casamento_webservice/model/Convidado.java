package com.casamento.casamento_webservice.model;

import com.casamento.casamento_webservice.model.enums.EPresenca;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "convidado")
public class Convidado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grupo_convite_id", nullable = false)
    private GrupoConvite grupoConvite;

    @Column(nullable = false, length = 150)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EPresenca presenca = EPresenca.PENDENTE;

    @Column(name = "data_confirmacao")
    private LocalDateTime dataConfirmacao;
}
