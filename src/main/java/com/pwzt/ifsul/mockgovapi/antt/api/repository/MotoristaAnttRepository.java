package com.pwzt.ifsul.mockgovapi.antt.api.repository;

import com.pwzt.ifsul.mockgovapi.antt.core.model.base.MotoristaAntt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotoristaAnttRepository extends JpaRepository<MotoristaAntt, Long> {

    Optional<MotoristaAntt> findByCpf(String cpf);
    Optional<MotoristaAntt> findByRntrc(String rntrc);

}
