package com.casamento.casamento_webservice.repository;

import com.casamento.casamento_webservice.model.Convidado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConvidadoRepository extends JpaRepository<Convidado, Integer> {

    Optional<Convidado> findByIdAndGrupoConviteToken(
            Integer id,
            String token
    );

    List<Convidado> findAllByIdInAndGrupoConviteToken(
            List<Integer> ids,
            String token
    );
}
