package com.pwzt.ifsul.mockgovapi.antt.core.factory;

import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro.ResponseCadastroMotoristaAntt;

import java.time.LocalDateTime;

public class ResponseAnttFactory {

    public static ResponseCadastroMotoristaAntt createResponseCadastroMotorista(String rntrc, String cpf, String nome){
        ResponseCadastroMotoristaAntt response = new ResponseCadastroMotoristaAntt();

        response.setDocumentoFiliado(cpf);
        response.setNomeFiliado(nome);
        response.setSituacaoRntrc("ATIVO");

        response.setCodigoStatusAntt("100");
        response.setMotivoAntt("Motorista cadastrado com sucesso");
        response.setRntrc(rntrc);
        response.setTimestamp(LocalDateTime.now());

        return response;
    }

}
