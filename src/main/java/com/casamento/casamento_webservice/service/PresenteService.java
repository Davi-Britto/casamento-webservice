package com.casamento.casamento_webservice.service;

import com.casamento.casamento_webservice.dto.request.AlterarPresentesRecebidosRequest;
import com.casamento.casamento_webservice.dto.request.PresenteRecebidoRequest;
import com.casamento.casamento_webservice.model.Presente;
import com.casamento.casamento_webservice.repository.PresenteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PresenteService {

    private final PresenteRepository repository;

    @Transactional(readOnly = true)
    public List<Presente> listarPresentes() {
        return repository.findAllByOrderByOrdemAscIdAsc();
    }

    @Transactional
    public void alterarRecebidos(AlterarPresentesRecebidosRequest request) {

        List<PresenteRecebidoRequest> presentesRequest = request.presentes();

        List<Integer> ids = presentesRequest.stream()
                .map(PresenteRecebidoRequest::id)
                .toList();

        Set<Integer> idsUnicos = new HashSet<>(ids);

        if (idsUnicos.size() != ids.size()) {
            throw new IllegalArgumentException(
                    "A requisição contém presentes duplicados."
            );
        }

        List<Presente> presentes = repository.findAllById(ids);

        if (presentes.size() != ids.size()) {
            throw new EntityNotFoundException(
                    "Um ou mais presentes não foram encontrados."
            );
        }

        Map<Integer, Presente> presentesMap = presentes.stream()
                .collect(Collectors.toMap(
                        Presente::getId,
                        Function.identity()
                ));

        for (PresenteRecebidoRequest presenteRequest : presentesRequest) {

            Presente presente = presentesMap.get(presenteRequest.id());

            presente.setRecebido(presenteRequest.recebido());
        }
    }
}