package br.com.estudos.controlefinanceiroapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.controlefinanceiroapi.model.entity.Despesa;
import br.com.estudos.controlefinanceiroapi.services.DespesaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/despesas")
@RequiredArgsConstructor
public class DespesaController {

	private final DespesaService despesaService;

	@PostMapping
	public ResponseEntity<Void> incluir(@RequestBody Despesa despesa) {
		despesaService.incluir(despesa);
		return ResponseEntity.ok().build();
	}

}
