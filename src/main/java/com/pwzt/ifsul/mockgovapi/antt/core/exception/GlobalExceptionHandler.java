package com.pwzt.ifsul.mockgovapi.antt.core.exception;

import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro.ResponseCadastroBaseAntt;
import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro.ResponseCadastroMotoristaAntt;
import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cte.ResponseCTeEmissao;
import com.pwzt.ifsul.mockgovapi.antt.core.factory.ResponseFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AnttValidationException.class)
    public ResponseEntity<ResponseCadastroBaseAntt> handleDocumentoValidationException(AnttValidationException e){
        ResponseCadastroBaseAntt response = ResponseFactory.createResponseAnttValidationException(e);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ExceptionHandler(CTeValidationException.class)
    public ResponseEntity<ResponseCTeEmissao> handleCTeValidationException(CTeValidationException e){
        ResponseCTeEmissao response = ResponseFactory.createResponseCTeValidationException(e);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
