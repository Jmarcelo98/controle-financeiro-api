package br.com.estudos.controlefinanceiroapi.services;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.handlers.NegocioException;
import br.com.estudos.controlefinanceiroapi.model.entity.TipoDespesa;
import br.com.estudos.controlefinanceiroapi.repositories.TipoDespesaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoDespesaService {

	private final TipoDespesaRepository despesaRepository;

	public void incluir(TipoDespesa tipoDespesa) {

		if (existeTipoDespesa(tipoDespesa)) {
			throw new NegocioException("Tipo de despesa já cadastrado");
		}

		despesaRepository.save(tipoDespesa);
	}

	private Boolean existeTipoDespesa(TipoDespesa tipoDespesa) {
		return despesaRepository.existsByDescricaoIgnoreCaseAndUsuario(tipoDespesa.getDescricao(), tipoDespesa.getUsuario());
	}

}
