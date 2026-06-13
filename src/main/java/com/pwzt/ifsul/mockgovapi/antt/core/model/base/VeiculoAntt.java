package com.pwzt.ifsul.mockgovapi.antt.core.model.base;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Table(name = "GBL_ANTT_MOT", indexes = {
        @Index(columnList = "VEI_ANTT_RNTRC"),
        @Index(columnList = "VEI_ANTT_PLACA")
})
@Entity

public class VeiculoAntt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEI_ANTT_ID")
    private Long id;

    @Column(name = "VEI_ANTT_PLACA")
    private String placa;

    @Convert(converter = TipoCarroceriaConverter.class)
    @Column(name = "VEI_ANTT_TIPOCARROCERIA")
    private TipoCarroceria tipoCarroceria;

    @Column(name = "VEI_ANTT_CAPACIDADEMAXIMA", scale = 15, precision = 2)
    private BigDecimal capacidadeMaxima;

    @Column(name = "VEI_ANTT_RNTRC")
    private String rntrc;

}
