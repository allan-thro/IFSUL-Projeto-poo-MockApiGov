package com.pwzt.ifsul.mockgovapi.antt.api.repository;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class InjectionProvider {

    @Autowired
    private MotoristaAnttRepository motoristaAnttRepositoryInject;

    @Getter private static MotoristaAnttRepository motoristaAnttRepository;

    @PostConstruct
    public void init(){
        InjectionProvider.motoristaAnttRepository = this.motoristaAnttRepositoryInject;
    }

}
