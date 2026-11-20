package com.casamento.casamento_webservice.repository;

import com.casamento.casamento_webservice.model.Presente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresenteRepository extends JpaRepository<Presente, Integer> {

    List<Presente> findAllByOrderByOrdemAscIdAsc();
}