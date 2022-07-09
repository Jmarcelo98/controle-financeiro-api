package br.com.estudos.controlefinanceiroapi.services;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.handlers.NegocioException;
import br.com.estudos.controlefinanceiroapi.model.entity.TipoDespesa;
import br.com.estudos.controlefinanceiroapi.repositories.TipoDespesaRepository;
import br.com.estudos.controlefinanceiroapi.utils.StringFormatoUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoDespesaService {

	private final TipoDespesaRepository despesaRepository;

	public void incluir(TipoDespesa tipoDespesa) {

		tipoDespesa.setDescricao(StringFormatoUtil.emMaiusculo(tipoDespesa.getDescricao()));

		if (existeTipoDespesa(tipoDespesa)) {
			throw new NegocioException("Tipo de despesa já cadastrado");
		}

		despesaRepository.save(tipoDespesa);
	}

	private Boolean existeTipoDespesa(TipoDespesa tipoDespesa) {
		return despesaRepository.existsByDescricaoAndUsuario(tipoDespesa.getDescricao(), tipoDespesa.getUsuario());
	}

}
