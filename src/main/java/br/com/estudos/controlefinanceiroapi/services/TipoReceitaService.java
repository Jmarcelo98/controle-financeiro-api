package br.com.estudos.controlefinanceiroapi.services;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.handlers.NegocioException;
import br.com.estudos.controlefinanceiroapi.model.entity.TipoReceita;
import br.com.estudos.controlefinanceiroapi.repositories.TipoReceitaRepository;
import br.com.estudos.controlefinanceiroapi.utils.StringFormatoUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoReceitaService {

	private final TipoReceitaRepository tipoReceitaRepository;

	public void incluir(TipoReceita tipoReceita) {

		tipoReceita.setDescricao(StringFormatoUtil.emMaiusculo(tipoReceita.getDescricao()));

		if (existeTipoReceita(tipoReceita)) {
			throw new NegocioException("Tipo de receita já cadastrada");
		}

		tipoReceitaRepository.save(tipoReceita);
	}

	private boolean existeTipoReceita(TipoReceita tipoReceita) {
		return tipoReceitaRepository.existsByDescricaoAndUsuario(tipoReceita.getDescricao(), tipoReceita.getUsuario());
	}

}
