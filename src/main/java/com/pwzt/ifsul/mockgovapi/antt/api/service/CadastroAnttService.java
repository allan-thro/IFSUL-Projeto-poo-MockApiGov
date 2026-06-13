package com.pwzt.ifsul.mockgovapi.antt.api.service;

import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro.ResponseCadastroMotoristaAntt;
import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro.ResponseCadastroVeiculoAntt;
import com.pwzt.ifsul.mockgovapi.antt.api.repository.InjectionProvider;
import com.pwzt.ifsul.mockgovapi.antt.core.exception.AnttValidationException;
import com.pwzt.ifsul.mockgovapi.antt.core.factory.ResponseAnttFactory;
import com.pwzt.ifsul.mockgovapi.antt.core.model.base.MotoristaAntt;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CadastroAnttService {

    public ResponseCadastroMotoristaAntt cadastrarMotoristaAntt(String cpf, String nome){
        Optional<MotoristaAntt> motoristaOpt = InjectionProvider.getMotoristaAnttRepository().findByCpf(cpf);
        if(motoristaOpt.isPresent()) throw new AnttValidationException("Motorista já cadastrado");

        MotoristaAntt motorista = new MotoristaAntt();
        motorista.setNome(nome);
        motorista.setCpf(cpf);

        String rntrc = createRntrc();

        motorista.setRNTRC(rntrc);

        InjectionProvider.getMotoristaAnttRepository().save(motorista);

        return ResponseAnttFactory.createResponseCadastroMotorista(rntrc, cpf, nome);
    }

    public ResponseCadastroVeiculoAntt cadastrarVeiculoAntt()

    private String createRntrc(){
        StringBuilder sb = new StringBuilder(8);

        for(int i = 0; i < 8; i++){
            int digito = ThreadLocalRandom.current().nextInt(0, 10);
            sb.append(digito);
        }

        return sb.toString();
    }

}
