package com.pwzt.ifsul.mockgovapi.antt.core.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

@XmlAccessorType(XmlAccessType.FIELD)
public class TcDest {

    @JsonProperty("cnpj")
    private String CNPJ;

    @JsonProperty("nome_destinatario")
    private String xNome;

    @XmlElement(name = "enderDest")
    @JsonProperty("endereco_destino")
    private TcEndereco tcEndereco;

}
