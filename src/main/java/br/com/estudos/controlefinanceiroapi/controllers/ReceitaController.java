package br.com.estudos.controlefinanceiroapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.controlefinanceiroapi.model.dtos.ReceitaDTO;
import br.com.estudos.controlefinanceiroapi.services.ReceitaServices;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/receitas")
@RequiredArgsConstructor
public class ReceitaController {

	private final ReceitaServices receitaServices;

	@PostMapping
	public ResponseEntity<Void> incluir(@RequestBody ReceitaDTO receitaDTO) {
		receitaServices.incluir(receitaDTO);
		return ResponseEntity.ok().build();
	}

	@PatchMapping
	public ResponseEntity<Void> atualizar(@RequestBody ReceitaDTO receitaDTO) {
		receitaServices.atualizar(receitaDTO);
		return ResponseEntity.ok().build();

	}

	@GetMapping
	ResponseEntity<List<ReceitaDTO>> buscarTodosPeloIdUsuario(Integer id) {
		return ResponseEntity.ok(receitaServices.buscarTodosPeloIdUsuario(id));

	}

}
