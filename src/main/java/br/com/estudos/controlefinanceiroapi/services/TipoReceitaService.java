package br.com.estudos.controlefinanceiroapi.services;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.model.entity.TipoReceita;
import br.com.estudos.controlefinanceiroapi.repositories.TipoReceitaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoReceitaService {
	
	private final TipoReceitaRepository tipoReceitaRepository;
	
		public void incluir(TipoReceita tipoReceita) {
			tipoReceitaRepository.save(tipoReceita);
		}

}
