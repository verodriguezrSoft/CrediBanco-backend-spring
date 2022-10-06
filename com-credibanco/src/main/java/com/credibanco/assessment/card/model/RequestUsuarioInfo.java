package com.credibanco.assessment.card.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
public class RequestUsuarioInfo {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pan;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal totalCompra;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String direccionCompra;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String estado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numeroReferecia;
}
