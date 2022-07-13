package br.com.estudos.controlefinanceiroapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.handlers.NegocioException;
import br.com.estudos.controlefinanceiroapi.mappers.TipoDespesaMapper;
import br.com.estudos.controlefinanceiroapi.model.dtos.TipoDespesaDTO;
import br.com.estudos.controlefinanceiroapi.model.entity.TipoDespesa;
import br.com.estudos.controlefinanceiroapi.repositories.TipoDespesaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoDespesaService {

	private final TipoDespesaRepository despesaRepository;

	private final UsuarioService usuarioService;

	public void incluir(TipoDespesa tipoDespesa) {

		if (existeTipoDespesa(tipoDespesa)) {
			throw new NegocioException("Tipo de despesa já cadastrado");
		}

		despesaRepository.save(tipoDespesa);
	}

	public List<TipoDespesaDTO> buscarTodosPeloIdUsuario(Integer id) {

		return TipoDespesaMapper.INSTANCE
				.listaEntityToListaDTO(despesaRepository.findAllByUsuario(usuarioService.buscarPeloId(id)));

	}

//	metodos privado

	private Boolean existeTipoDespesa(TipoDespesa tipoDespesa) {
		return despesaRepository.existsByDescricaoIgnoreCaseAndUsuario(tipoDespesa.getDescricao(),
				tipoDespesa.getUsuario());
	}

}
