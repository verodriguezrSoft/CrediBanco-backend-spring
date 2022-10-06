package com.credibanco.assessment.card.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "TRANSACCION")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PAN", nullable = false)
    private String PAN;

    @Column(name = "TOTAL_COMPRA", nullable = false)
    private BigDecimal totalCompra;

    @Column(name = "DIRECCION_COMPRA", nullable = false)
    private String direccionCompra;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "NUMERO_REFERENCIA", nullable = false)
    private String numeroReferecia;

    @Column(name = "FECHA", nullable = false)
    private Date fecha;

}
