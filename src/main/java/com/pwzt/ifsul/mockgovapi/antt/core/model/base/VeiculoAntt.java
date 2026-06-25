package com.pwzt.ifsul.mockgovapi.antt.core.model.base;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Table(name = "GBL_ANTT_VEI", indexes = {
        @Index(columnList = "VEI_ANTT_RNTRC"),
        @Index(columnList = "VEI_ANTT_PLACA")
})
@Entity
@Data

public class VeiculoAntt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEI_ANTT_ID")
    private Long id;

    @Column(name = "VEI_ANTT_PLACA")
    private String placa;

    @Column(name = "VEI_ANTT_CAPACIDADEMAXIMA", precision = 15, scale = 2)
    private BigDecimal capacidadeMaxima;

    @Column(name = "VEI_ANTT_RNTRC")
    private String rntrc;

}
