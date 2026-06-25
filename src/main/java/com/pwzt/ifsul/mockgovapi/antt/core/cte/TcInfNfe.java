package com.pwzt.ifsul.mockgovapi.antt.core.cte;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

@XmlAccessorType(XmlAccessType.FIELD)
public class TcInfNfe {

    @JsonProperty("chave")
    private String chave;

}
