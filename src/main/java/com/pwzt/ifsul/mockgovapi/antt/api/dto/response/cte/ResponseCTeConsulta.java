package com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCTeConsulta extends ResponseCTe{

    @JsonProperty("chave_cte")
    private String chaveCte;

    @JsonProperty("protocolo_autorizacao")
    private String protocoloAutorizacao;

}
