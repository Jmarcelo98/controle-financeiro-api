package br.com.estudos.controlefinanceiroapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.controlefinanceiroapi.model.entity.Receita;
import br.com.estudos.controlefinanceiroapi.services.ReceitaServices;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/receitas")
@RequiredArgsConstructor
public class ReceitaController {
	
	private final ReceitaServices receitaServices;
	
	
	@PostMapping
	public ResponseEntity<Void> incluir(@RequestBody Receita receita) {		
		receitaServices.incluir(receita);
		return ResponseEntity.ok().build();
	}
	
		
	

}
