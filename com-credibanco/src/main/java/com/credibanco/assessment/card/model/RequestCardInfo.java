package com.credibanco.assessment.card.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestCardInfo {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pan;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer cedula;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String titular;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String debitoCredito;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String telefono;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String estado;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer numeroValidacion;
}
