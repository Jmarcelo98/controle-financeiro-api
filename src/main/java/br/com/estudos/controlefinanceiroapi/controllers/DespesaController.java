package br.com.estudos.controlefinanceiroapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.controlefinanceiroapi.model.dtos.DespesaDTO;
import br.com.estudos.controlefinanceiroapi.services.DespesaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/despesas")
@RequiredArgsConstructor
public class DespesaController {

	private final DespesaService despesaService;

	@PostMapping
	public ResponseEntity<Void> incluir(@RequestBody DespesaDTO despesaDTO) {
		despesaService.incluir(despesaDTO);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<Void> atualizar(@RequestBody DespesaDTO despesaDTO) {
		despesaService.atualizar(despesaDTO);
		return ResponseEntity.ok().build();
	}
}
