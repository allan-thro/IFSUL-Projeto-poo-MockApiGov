package com.pwzt.ifsul.mockgovapi.antt.core.model.base;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "GBL_ANTT_MOT", indexes = {
        @Index(columnList = "MOT_ANTT_CPF"),
        @Index(columnList = "MOT_ANTT_RNTRC")
})
@Entity
@Data

public class MotoristaAntt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOT_ANTT_ID")
    private Long id;

    @Column(name = "MOT_ANTT_NOME")
    private String nome;

    @Column(name = "MOT_ANTT_CPF")
    private String cpf;

    @Column(name = "MOT_ANTT_RNTRC")
    private String rntrc;

}
