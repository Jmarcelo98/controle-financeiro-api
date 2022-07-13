package br.com.estudos.controlefinanceiroapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.controlefinanceiroapi.model.dtos.TipoReceitaDTO;
import br.com.estudos.controlefinanceiroapi.model.entity.TipoReceita;
import br.com.estudos.controlefinanceiroapi.services.TipoReceitaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tipo-receita")
@RequiredArgsConstructor
public class TipoReceitaController {

	private final TipoReceitaService tipoReceitaService;

	@PostMapping
	private ResponseEntity<Void> incluir(@RequestBody TipoReceita tipoReceita) {
		tipoReceitaService.incluir(tipoReceita);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	private ResponseEntity<List<TipoReceitaDTO>> buscarTodosPeloIdUsuario(Integer id) {
		return ResponseEntity.ok(tipoReceitaService.buscarTodosPeloIdUsuario(id));
	}

}
