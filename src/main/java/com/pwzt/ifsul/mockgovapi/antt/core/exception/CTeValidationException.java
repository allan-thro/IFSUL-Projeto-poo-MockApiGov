package com.pwzt.ifsul.mockgovapi.antt.core.exception;

import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.ResponseMensagem;
import lombok.Data;

import java.util.List;

@Data
public class CTeValidationException extends RuntimeException {
    List<ResponseMensagem> erroList;

    public CTeValidationException(String message, List<ResponseMensagem> erroList) {
        this.erroList = erroList;
        super(message);
    }

}
