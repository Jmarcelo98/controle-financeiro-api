package br.com.estudos.controlefinanceiroapi.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.handlers.NegocioException;
import br.com.estudos.controlefinanceiroapi.handlers.RecursoNaoEncontradoException;
import br.com.estudos.controlefinanceiroapi.mappers.generic.TipoReceitaMapper;
import br.com.estudos.controlefinanceiroapi.model.dtos.TipoReceitaDTO;
import br.com.estudos.controlefinanceiroapi.model.entity.TipoReceita;
import br.com.estudos.controlefinanceiroapi.repositories.TipoReceitaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoReceitaService {

	private final TipoReceitaRepository tipoReceitaRepository;
	private final UsuarioService usuarioService;

	public void incluir(TipoReceita tipoReceita) {

		if (existeTipoReceita(tipoReceita)) {
			throw new NegocioException("Tipo de receita já cadastrada");
		}

		tipoReceitaRepository.save(tipoReceita);
	}
	
	public List<TipoReceitaDTO> buscarTodosPeloIdUsuario(Integer id){
		return TipoReceitaMapper.INSTANCE
				.listaEntityToListaDTO(tipoReceitaRepository.findAllByUsuario(usuarioService.buscarPeloId(id)));
	}
	
	public void atualizar (TipoReceitaDTO tipoReceitaDTO) {
		var tipoReceita = tipoReceitaRepository.findById(tipoReceitaDTO.getId())
				.orElseThrow(() -> new RecursoNaoEncontradoException("Tipo de Receita não encontrado pelo ID"));
		
		BeanUtils.copyProperties(tipoReceitaDTO, tipoReceita);
		tipoReceitaRepository.save(tipoReceita);
		
	}

	// private metodos

	private boolean existeTipoReceita(TipoReceita tipoReceita) {
		return tipoReceitaRepository.existsByDescricaoIgnoreCaseAndUsuario(tipoReceita.getDescricao(),
				tipoReceita.getUsuario());
	}

}
