package br.com.estudos.controlefinanceiroapi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.handlers.NegocioException;
import br.com.estudos.controlefinanceiroapi.handlers.RecursoNaoEncontradoException;
import br.com.estudos.controlefinanceiroapi.mappers.TipoDespesaMapper;
import br.com.estudos.controlefinanceiroapi.model.dtos.TipoDespesaDTO;
import br.com.estudos.controlefinanceiroapi.model.entity.Despesa;
import br.com.estudos.controlefinanceiroapi.model.entity.TipoDespesa;
import br.com.estudos.controlefinanceiroapi.repositories.TipoDespesaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoDespesaService {

	private final TipoDespesaRepository tipoDespesaRepository;

	private final UsuarioService usuarioService;

	@Transactional
	public void incluir(TipoDespesa tipoDespesa) {

		if (existeTipoDespesa(tipoDespesa)) {
			throw new NegocioException("Tipo de despesa já cadastrado");
		}

		tipoDespesaRepository.save(tipoDespesa);
	}

	@Transactional
	public void atualizar(TipoDespesaDTO tipoDespesaDTO) {

		var tipoDespesa = tipoDespesaRepository.findById(tipoDespesaDTO.getId())
				.orElseThrow(() -> new RecursoNaoEncontradoException("Tipo de despesa não encontrada pelo ID"));

		BeanUtils.copyProperties(tipoDespesaDTO, tipoDespesa);

		tipoDespesaRepository.save(tipoDespesa);

	}

	@Transactional
	public void deletar(Integer id) {

		var tipoDespesa = tipoDespesaRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Tipo de despesa não encontrada pelo ID"));

		for (Despesa despesa : tipoDespesa.getDespesas()) {
			despesa.setTipoDespesa(null);
		}

		tipoDespesaRepository.deleteById(id);
	}

	public List<TipoDespesaDTO> buscarTodosPeloIdUsuario(Integer id) {

		return TipoDespesaMapper.INSTANCE
				.listaEntityToListaDTO(tipoDespesaRepository.findAllByUsuario(usuarioService.buscarPeloId(id)));

	}

//	metodos privado

	private Boolean existeTipoDespesa(TipoDespesa tipoDespesa) {
		return tipoDespesaRepository.existsByDescricaoIgnoreCaseAndUsuario(tipoDespesa.getDescricao(),
				tipoDespesa.getUsuario());
	}

}
