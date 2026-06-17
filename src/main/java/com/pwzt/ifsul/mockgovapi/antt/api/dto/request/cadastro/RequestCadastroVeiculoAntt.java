package com.pwzt.ifsul.mockgovapi.antt.api.dto.request.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data

public class RequestCadastroVeiculoAntt {

    private String placa;

    @JsonProperty("capacidade_maxima")
    private String capacidadeMaxima;

    private String rntrc;

}
