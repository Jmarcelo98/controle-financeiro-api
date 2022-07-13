package br.com.estudos.controlefinanceiroapi.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.handlers.RecursoNaoEncontradoException;
import br.com.estudos.controlefinanceiroapi.mappers.DespesaMapper;
import br.com.estudos.controlefinanceiroapi.model.dtos.DespesaDTO;
import br.com.estudos.controlefinanceiroapi.repositories.DespesaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DespesaService {

	private final DespesaRepository despesaRepository;

	public void incluir(DespesaDTO despesaDTO) {

		var despesa = DespesaMapper.INSTANCE.DTOToEntity(despesaDTO);

		despesaRepository.save(despesa);
	}

	public void atualizar(DespesaDTO despesaDTO) {

		var despesa = despesaRepository.findById(despesaDTO.getId())
				.orElseThrow(() -> new RecursoNaoEncontradoException("Despesa não encontrada pelo ID"));

		BeanUtils.copyProperties(despesaDTO, despesa);

		despesaRepository.save(despesa);

	}

}
