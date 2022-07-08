package br.com.estudos.controlefinanceiroapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.controlefinanceiroapi.model.entity.TipoDespesa;
import br.com.estudos.controlefinanceiroapi.services.TipoDespesaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tipo-despesa")
@RequiredArgsConstructor
public class TipoDespesaController {

	private final TipoDespesaService tipoDespesaService;

	@PostMapping
	ResponseEntity<Void> incluir(@RequestBody TipoDespesa tipoDespesa) {
		tipoDespesaService.incluir(tipoDespesa);
		return ResponseEntity.ok().build();
	}

}
