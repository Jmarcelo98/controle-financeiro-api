package br.com.estudos.controlefinanceiroapi.services;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.model.entity.Despesa;
import br.com.estudos.controlefinanceiroapi.repositories.DespesaRepository;
import br.com.estudos.controlefinanceiroapi.utils.StringFormatoUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DespesaService {

	private final DespesaRepository despesaRepository;

	public void incluir(Despesa despesa) {
		despesa.setDescricao(StringFormatoUtil.emMaiusculo(despesa.getDescricao()));
		despesaRepository.save(despesa);
	}

}
