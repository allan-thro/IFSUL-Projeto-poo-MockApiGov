package com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cte;

import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.ResponseMensagem;
import lombok.Data;

import java.util.List;

@Data

public class ResponseCTe {

    private String status;

    private List<ResponseMensagem> mensagem;

}
