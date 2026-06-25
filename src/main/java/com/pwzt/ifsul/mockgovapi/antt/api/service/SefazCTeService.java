package com.pwzt.ifsul.mockgovapi.antt.api.service;

import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cte.ResponseCTeEmissao;
import com.pwzt.ifsul.mockgovapi.antt.core.cte.TcCTE;
import com.pwzt.ifsul.mockgovapi.antt.core.cte.TcInfCTE;
import com.pwzt.ifsul.mockgovapi.antt.core.exception.CTeValidationException;
import com.pwzt.ifsul.mockgovapi.antt.core.factory.ResponseFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SefazCTeService {

    public ResponseCTeEmissao emitirCTe(TcCTE cte){
        List<ResponseMensagem> mensagemList = new ArrayList<>();
        String chaveCte = "";

        try{
            chaveCte = geradorChaveCTe(cte.getInfCTE());
        } catch (Exception e){
            mensagemList.add(
                    new ResponseMensagem.Builder()
                            .descricao("Não foi possivel gerar chave")
                            .codigo("305")
                            .erro()
                            .build()
            );
        }

        if(cte.getInfCTE().getTcDest() == null){
            mensagemList.add(
                    new ResponseMensagem.Builder()
                            .descricao("É obrigatório informar um destinatário")
                            .codigo("305")
                            .erro()
                            .build()
            );
        }

        if(cte.getInfCTE().getTcEmit() == null){
            mensagemList.add(
                    new ResponseMensagem.Builder()
                            .descricao("É obrigatório informar o emitente")
                            .codigo("305")
                            .erro()
                            .build()
            );
        }

        if(cte.getInfCTE().getTcRem() == null){
            mensagemList.add(
                    new ResponseMensagem.Builder()
                            .descricao("É obrigatório informar o remetente")
                            .codigo("305")
                            .erro()
                            .build()
            );
        }

        if(cte.getInfCTE().getTcInfCTeNorm().getTcInfCarga() == null){
            mensagemList.add(
                    new ResponseMensagem.Builder()
                            .descricao("Informações da carga inválidas")
                            .codigo("305")
                            .erro()
                            .build()
            );
        }

        if(!mensagemList.isEmpty()) throw new CTeValidationException("Erro ao emitir CTe", mensagemList);

        return ResponseFactory.createResponseCTeEmissaoSucesso(chaveCte);
    }

    private static String geradorChaveCTe(TcInfCTE infCte){
        String chave = "";

        chave = chave.concat(infCte.getTcIde().getCMunEnv().substring(0, 2));
        chave = chave.concat(infCte.getTcIde().getDhEmi().substring(2, 4));
        chave = chave.concat(infCte.getTcIde().getDhEmi().substring(5, 7));
        chave = chave.concat(infCte.getTcEmit().getCNPJ());
        chave = chave.concat(infCte.getTcIde().getMod());
        chave = chave.concat(infCte.getTcIde().getSerie());
        chave = chave.concat(infCte.getTcIde().getCCT());
        chave = chave.concat(infCte.getTcInfCTeNorm().getTcInfDoc().getTcInfNfe().getChave().substring(0, 9));
        chave = chave.concat("7");

        return chave;
    }

}
