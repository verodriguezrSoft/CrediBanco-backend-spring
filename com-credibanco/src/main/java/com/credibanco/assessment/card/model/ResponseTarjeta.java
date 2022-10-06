package com.credibanco.assessment.card.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTarjeta {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String codigo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String panEnmascarado;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer numeroValidacion;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String estadoTransaccion;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numeroReferencia;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String titular;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer cedula;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String telefono;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String estado;

}
