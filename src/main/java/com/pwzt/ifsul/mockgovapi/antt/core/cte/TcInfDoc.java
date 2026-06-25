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
public class TcInfDoc {

    @XmlElement(name = "infNfe")
    @JsonProperty("informacao_nfe")
    private TcInfNfe tcInfNfe;

}
