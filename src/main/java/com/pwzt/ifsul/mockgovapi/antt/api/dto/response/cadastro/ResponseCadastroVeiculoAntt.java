package com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class ResponseCadastroVeiculoAntt extends ResponseCadastroBaseAntt {

    @JsonProperty("capacidade_maxima_carga_kg")
    private String capacidadeMaximaCargaKg;

    private String placa;

}