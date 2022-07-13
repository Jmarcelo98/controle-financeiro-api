package br.com.estudos.controlefinanceiroapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.handlers.NegocioException;
import br.com.estudos.controlefinanceiroapi.mappers.TipoReceitaMapper;
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

	public List<TipoReceitaDTO> buscarTodosPeloIdUsuario(Integer id) {

		return TipoReceitaMapper.INSTANCE
				.listaEntityToListaDTO(tipoReceitaRepository.findAllByUsuario(usuarioService.buscarPeloId(id)));

	}

	// private metodos

	private boolean existeTipoReceita(TipoReceita tipoReceita) {
		return tipoReceitaRepository.existsByDescricaoIgnoreCaseAndUsuario(tipoReceita.getDescricao(),
				tipoReceita.getUsuario());
	}

}
