package com.casamento.casamento_webservice.service;

import com.casamento.casamento_webservice.dto.request.AlterarPresencasRequest;
import com.casamento.casamento_webservice.dto.request.ConvidadoPresencaRequest;
import com.casamento.casamento_webservice.model.Convidado;
import com.casamento.casamento_webservice.model.GrupoConvite;
import com.casamento.casamento_webservice.model.enums.EPresenca;
import com.casamento.casamento_webservice.repository.ConvidadoRepository;
import com.casamento.casamento_webservice.repository.GrupoConviteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoConviteService {

    private final GrupoConviteRepository repository;
    private final ConvidadoRepository convidadoRepository;

    public GrupoConvite findByToken(String token) {
        return repository.findByToken(token).orElse(null);
    }

    @Transactional
    public void alterarPresencas(String token, AlterarPresencasRequest request) {
        findByToken(token);

        List<Integer> ids = request.convidados()
                .stream()
                .map(convidado -> convidado.id())
                .toList();

        List<Convidado> convidados = convidadoRepository.findAllByIdInAndGrupoConviteToken(ids, token);

        if (convidados.size() != ids.size()) {
            throw new EntityNotFoundException("Um ou mais convidados não pertencem ao convite.");
        }

        for (ConvidadoPresencaRequest requestConvidado : request.convidados()) {

            Convidado convidado = convidados.stream()
                    .filter(item -> item.getId().equals(requestConvidado.id()))
                    .findFirst()
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Convidado não encontrado."
                    ));

            EPresenca presenca = requestConvidado.presenca();

            convidado.setPresenca(presenca);

            if (presenca == EPresenca.PENDENTE) {
                convidado.setDataConfirmacao(null);
            } else {
                convidado.setDataConfirmacao(LocalDateTime.now());
            }
        }
    }
}