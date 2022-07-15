package br.com.estudos.controlefinanceiroapi.services;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.estudos.controlefinanceiroapi.handlers.RecursoNaoEncontradoException;
import br.com.estudos.controlefinanceiroapi.mappers.UsuarioMapper;
import br.com.estudos.controlefinanceiroapi.model.dtos.UsuarioDTO;
import br.com.estudos.controlefinanceiroapi.model.entity.Usuario;
import br.com.estudos.controlefinanceiroapi.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Transactional
	public UsuarioDTO atualizar(Integer id, MultipartFile foto) {

		var usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado pelo ID"));

		try {

			if (foto != null) {
				usuario.setFoto(foto.getBytes());
				usuarioRepository.save(usuario);
			}

		} catch (IOException e) {
			log.error("Erro ao cadastrar foto");
			e.printStackTrace();
		}

		return UsuarioMapper.INSTANCE.entityToDTO(usuario);
	}

	@Transactional
	public void deletar(Integer id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario buscarPeloId(Integer id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado através do ID"));
	}

}
