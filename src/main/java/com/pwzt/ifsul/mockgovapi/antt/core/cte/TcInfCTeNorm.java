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
public class TcInfCTeNorm {

    @XmlElement(name = "infCarga")
    @JsonProperty("informacao_carga")
    private TcInfCarga tcInfCarga;

    @XmlElement(name = "infDoc")
    @JsonProperty("informacao_documento")
    private TcInfDoc tcInfDoc;

}
