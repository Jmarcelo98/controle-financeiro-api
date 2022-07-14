package br.com.estudos.controlefinanceiroapi.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.handlers.RecursoNaoEncontradoException;
import br.com.estudos.controlefinanceiroapi.mappers.generic.ReceitaMapper;
import br.com.estudos.controlefinanceiroapi.model.dtos.ReceitaDTO;
import br.com.estudos.controlefinanceiroapi.repositories.ReceitaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReceitaServices {

	private final ReceitaRepository receitaRepository;
	
	private final UsuarioService usuarioService;

	public void incluir(ReceitaDTO receitaDTO) {
		var receita = ReceitaMapper.INSTANCE.DTOToEntity(receitaDTO);
		receitaRepository.save(receita);
	}

	public void atualizar(ReceitaDTO receitaDTO) {
		var receita = receitaRepository.findById(receitaDTO.getId())
				.orElseThrow(() -> new RecursoNaoEncontradoException("Receita não encontrada pelo ID"));
		
		BeanUtils.copyProperties(receitaDTO, receita);
		receitaRepository.save(receita);

	}

	public List<ReceitaDTO> buscarTodosPeloIdUsuario(Integer id) {
		return ReceitaMapper.INSTANCE
				.listaEntityToListaDTO(receitaRepository.findAllByUsuario(usuarioService.buscarPeloId(id)));

	}

}
