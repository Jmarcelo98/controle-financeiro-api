package br.com.estudos.controlefinanceiroapi.services;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.model.entity.Receita;
import br.com.estudos.controlefinanceiroapi.repositories.ReceitaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReceitaServices {
	
	private final ReceitaRepository receitaRepository;
	
	
	public void incluir(Receita receita){		
		receitaRepository.save(receita);	
		
		
	}

}
