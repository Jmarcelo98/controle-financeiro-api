package br.com.estudos.controlefinanceiroapi.services;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.model.entity.Receita;
import br.com.estudos.controlefinanceiroapi.repositories.ReceitaRepository;
import br.com.estudos.controlefinanceiroapi.utils.StringFormatoUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReceitaServices {
	
	private final ReceitaRepository receitaRepository;
	
	
	public void incluir(Receita receita){	
		receita.setDescricao(StringFormatoUtil.emMaiusculo(receita.getDescricao()));
		receitaRepository.save(receita);	
		
		
	}

}
