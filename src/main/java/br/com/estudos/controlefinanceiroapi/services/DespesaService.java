package br.com.estudos.controlefinanceiroapi.services;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.model.entity.Despesa;
import br.com.estudos.controlefinanceiroapi.repositories.DespesaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DespesaService {

	private final DespesaRepository despesaRepository;

	public void incluir(Despesa despesa) {
		despesaRepository.save(despesa);
	}

}
