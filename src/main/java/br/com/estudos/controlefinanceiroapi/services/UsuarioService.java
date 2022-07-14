package br.com.estudos.controlefinanceiroapi.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.handlers.RecursoNaoEncontradoException;
import br.com.estudos.controlefinanceiroapi.model.entity.Usuario;
import br.com.estudos.controlefinanceiroapi.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Transactional
	public void deletar(Integer id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario buscarPeloId(Integer id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado através do ID"));
	}

}
