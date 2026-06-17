package com.pwzt.ifsul.mockgovapi.antt.api.service;

import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro.ResponseCadastroMotoristaAntt;
import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro.ResponseCadastroVeiculoAntt;
import com.pwzt.ifsul.mockgovapi.antt.api.repository.InjectionProvider;
import com.pwzt.ifsul.mockgovapi.antt.api.repository.VeiculoAnttRepository;
import com.pwzt.ifsul.mockgovapi.antt.core.exception.AnttValidationException;
import com.pwzt.ifsul.mockgovapi.antt.core.factory.ResponseAnttFactory;
import com.pwzt.ifsul.mockgovapi.antt.core.model.base.MotoristaAntt;
import com.pwzt.ifsul.mockgovapi.antt.core.model.base.VeiculoAntt;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CadastroAnttService {

    private final VeiculoAnttRepository veiculoAnttRepository;

    public CadastroAnttService(VeiculoAnttRepository veiculoAnttRepository) {
        this.veiculoAnttRepository = veiculoAnttRepository;
    }

    public ResponseCadastroMotoristaAntt cadastrarMotoristaAntt(String cpf, String nome){
        Optional<MotoristaAntt> motoristaOpt = InjectionProvider.getMotoristaAnttRepository().findByCpf(cpf);
        if(motoristaOpt.isPresent()) throw new AnttValidationException("Motorista já cadastrado");

        MotoristaAntt motorista = new MotoristaAntt();
        motorista.setNome(nome);
        motorista.setCpf(cpf);

        String rntrc = createRntrc();

        motorista.setRntrc(rntrc);

        InjectionProvider.getMotoristaAnttRepository().save(motorista);

        return ResponseAnttFactory.createResponseCadastroMotorista(rntrc, cpf, nome);
    }

    public ResponseCadastroVeiculoAntt cadastrarVeiculoAntt(String placa, String rntrc, BigDecimal capacidadeMaxima){
        MotoristaAntt motoristaBd = InjectionProvider.getMotoristaAnttRepository().findByRntrc(rntrc)
                .orElseThrow(() -> new AnttValidationException("Rntrc não vinculado a um motorista cadastrado"));

        Optional<VeiculoAntt> veiculoBd = InjectionProvider.getVeiculoAnttRepository().findByPlaca(placa);

        if(veiculoBd.isPresent()) throw new AnttValidationException("Veiculo com a placa já cadastrada no sistema");

        VeiculoAntt veiculo = new VeiculoAntt();

        veiculo.setCapacidadeMaxima(capacidadeMaxima);
        veiculo.setPlaca(placa);
        veiculo.setRntrc(rntrc);

        InjectionProvider.getVeiculoAnttRepository().save(veiculo);

        return ResponseAnttFactory.createResponseCadastroVeiculo(placa, rntrc, capacidadeMaxima);
    }

    private String createRntrc(){
        StringBuilder sb = new StringBuilder(8);

        for(int i = 0; i < 8; i++){
            int digito = ThreadLocalRandom.current().nextInt(0, 10);
            sb.append(digito);
        }

        return sb.toString();
    }

}
