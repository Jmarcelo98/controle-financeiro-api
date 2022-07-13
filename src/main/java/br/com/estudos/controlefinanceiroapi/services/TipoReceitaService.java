package br.com.estudos.controlefinanceiroapi.services;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.handlers.NegocioException;
import br.com.estudos.controlefinanceiroapi.model.entity.TipoReceita;
import br.com.estudos.controlefinanceiroapi.repositories.TipoReceitaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoReceitaService {

	private final TipoReceitaRepository tipoReceitaRepository;

	public void incluir(TipoReceita tipoReceita) {

		if (existeTipoReceita(tipoReceita)) {
			throw new NegocioException("Tipo de receita já cadastrada");
		}

		tipoReceitaRepository.save(tipoReceita);
	}

	// private metodos

	private boolean existeTipoReceita(TipoReceita tipoReceita) {
		return tipoReceitaRepository.existsByDescricaoIgnoreCaseAndUsuario(tipoReceita.getDescricao(),
				tipoReceita.getUsuario());
	}

}
