package br.com.estudos.controlefinanceiroapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.controlefinanceiroapi.services.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
	
	private final UsuarioService usuarioService;

	@DeleteMapping
	ResponseEntity<Void> deletar(Integer id) {
		usuarioService.deletar(id);
		return ResponseEntity.ok().build();
	}
	
}