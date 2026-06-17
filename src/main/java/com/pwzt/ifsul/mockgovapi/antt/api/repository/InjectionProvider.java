package com.pwzt.ifsul.mockgovapi.antt.api.repository;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class InjectionProvider {

    @Autowired
    private MotoristaAnttRepository motoristaAnttRepositoryInject;

    @Autowired
    private VeiculoAnttRepository veiculoAnttRepositoryInject;

    @Getter private static MotoristaAnttRepository motoristaAnttRepository;
    @Getter private static VeiculoAnttRepository veiculoAnttRepository;

    @PostConstruct
    public void init(){
        InjectionProvider.motoristaAnttRepository = this.motoristaAnttRepositoryInject;
        InjectionProvider.veiculoAnttRepository = this.veiculoAnttRepositoryInject;
    }

}
