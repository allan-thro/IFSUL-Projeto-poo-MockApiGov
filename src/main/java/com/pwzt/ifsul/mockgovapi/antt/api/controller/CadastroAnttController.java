package com.pwzt.ifsul.mockgovapi.antt.api.controller;

import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro.ResponseCadastroMotoristaAntt;
import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cadastro.ResponseCadastroVeiculoAntt;
import com.pwzt.ifsul.mockgovapi.antt.api.service.CadastroAnttService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("/api/antt/cadastro")
@RestController

@AllArgsConstructor
public class CadastroAnttController {


    private final CadastroAnttService cadastroAnttService;

    @PostMapping("/motorista")
    public ResponseEntity<ResponseCadastroMotoristaAntt> cadastrarMotoristaAntt(
            @RequestParam String cpf,
            @RequestParam String nome
    ){
        ResponseCadastroMotoristaAntt response = cadastroAnttService.cadastrarMotoristaAntt(cpf, nome);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/veiculo")
    public ResponseEntity<ResponseCadastroVeiculoAntt> cadastrarVeiculoAntt(
            @RequestParam String placa,
            @RequestParam String rntrc,
            @RequestParam("capacidade_maxima") BigDecimal capacidadeMaxima
            ){
        ResponseCadastroVeiculoAntt response = cadastroAnttService.cadastrarVeiculoAntt(placa, rntrc, capacidadeMaxima);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
