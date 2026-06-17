package com.pwzt.ifsul.mockgovapi.antt.api.repository;

import com.pwzt.ifsul.mockgovapi.antt.core.model.base.VeiculoAntt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoAnttRepository extends JpaRepository<VeiculoAntt, Long> {

    Optional<VeiculoAntt> findByPlaca(String placa);

}
