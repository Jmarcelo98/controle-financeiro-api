package br.com.estudos.controlefinanceiroapi.services;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.model.entity.TipoDespesa;
import br.com.estudos.controlefinanceiroapi.repositories.TipoDespesaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoDespesaService {

	private final TipoDespesaRepository despesaRepository;

	public void incluir(TipoDespesa tipoDespesa) {
		despesaRepository.save(tipoDespesa);
	}

}
