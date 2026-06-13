package com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseCadastroBaseAntt {

    @JsonProperty("codigo_status_antt")
    private String codigoStatusAntt;

    @JsonProperty("motivo_antt")
    private String motivoAntt;

    private String rntrc;

    private LocalDateTime timestamp;

}

