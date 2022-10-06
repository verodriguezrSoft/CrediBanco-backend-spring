package com.credibanco.assessment.card.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "TARJETA_ENTITY")
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PAN", nullable = false)
    private String PAN;

    @Column(name = "NUMERO_VALIDACION")
    private Integer numeroValidacion;

    @Column(name = "TITULAR", nullable = false)
    private String titular;

    @Column(name = "CEDULA", nullable = false)
    private Integer cedula;

    @Column(name = "DEBITO_CREDITO", nullable = false)
    private String debitoCredito;

    @Column(name = "TELEFONO", nullable = false)
    private String telefono;

    @Column(name = "ESTADO")
    private String estado;
}

