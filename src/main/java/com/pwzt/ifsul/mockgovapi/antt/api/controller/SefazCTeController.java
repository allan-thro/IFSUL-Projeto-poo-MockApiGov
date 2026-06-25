package com.pwzt.ifsul.mockgovapi.antt.api.controller;

import com.pwzt.ifsul.mockgovapi.antt.api.dto.response.cte.ResponseCTeEmissao;
import com.pwzt.ifsul.mockgovapi.antt.api.service.SefazCTeService;
import com.pwzt.ifsul.mockgovapi.antt.core.cte.TcCTE;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/sefaz/cte")
@RestController

@RequiredArgsConstructor
public class SefazCTeController {

    private final SefazCTeService cteService;

    @PostMapping("/emitir")
    ResponseEntity<ResponseCTeEmissao> recepcaoCTeEmissao(@RequestBody TcCTE cte){
        ResponseCTeEmissao response = cteService.emitirCTe(cte);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
