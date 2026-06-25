package com.pwzt.ifsul.mockgovapi.antt.core.factory;

import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro.ResponseCadastroMotoristaAntt;
import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro.ResponseCadastroVeiculoAntt;
import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cte.ResponseCTe;
import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cte.ResponseCTeEmissao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ResponseFactory {

    public static ResponseCadastroMotoristaAntt createResponseCadastroMotorista(String rntrc, String cpf, String nome){
        ResponseCadastroMotoristaAntt response = new ResponseCadastroMotoristaAntt();

        response.setDocumentoFiliado(cpf);
        response.setNomeFiliado(nome);
        response.setSituacaoRntrc("ATIVO");

        response.setCodigoStatusAntt("100");
        response.setMotivoAntt("Motorista cadastrado com sucesso");
        response.setValidadeRntrc(LocalDate.now().plusMonths(6));
        response.setRntrc(rntrc);
        response.setTimestamp(LocalDateTime.now());

        return response;
    }

    public static ResponseCadastroVeiculoAntt createResponseCadastroVeiculo(String placa, String rntrc, BigDecimal capacidadeMaxima){
        ResponseCadastroVeiculoAntt response = new ResponseCadastroVeiculoAntt();

        response.setCapacidadeMaximaCargaKg(capacidadeMaxima.toString());
        response.setPlaca(placa);

        response.setCodigoStatusAntt("100");
        response.setMotivoAntt("Veiculo cadastrado com sucesso");
        response.setRntrc(rntrc);
        response.setTimestamp(LocalDateTime.now());

        return response;
    }

    public static ResponseCTeEmissao createResponseCTeEmissaoSucesso(String chaveCTe){
        ResponseCTeEmissao response = new ResponseCTeEmissao();

        response.setCodigo("205");
        response.setMotivo("CTe Autorizada pela Sefaz");
        response.setChaveCte(chaveCTe);
        response.setDataAutorizacao(LocalDateTime.now());

        return response;
    }

}
