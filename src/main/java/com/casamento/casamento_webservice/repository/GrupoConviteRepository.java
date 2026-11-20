package com.casamento.casamento_webservice.repository;

import com.casamento.casamento_webservice.model.GrupoConvite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrupoConviteRepository extends JpaRepository<GrupoConvite, Integer> {

    Optional<GrupoConvite> findByToken(String token);
}
