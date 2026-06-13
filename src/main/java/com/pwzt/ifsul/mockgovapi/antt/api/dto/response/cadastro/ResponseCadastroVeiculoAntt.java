package com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCadastroVeiculoAntt extends ResponseCadastroBaseAntt {

    @JsonProperty("tipo_carroceria")
    private String tipoCarroceria;

    @JsonProperty("capacidade_maxima_carga_kg")
    private String capacidadeMaximaCargaKg;

    private String placa;

}