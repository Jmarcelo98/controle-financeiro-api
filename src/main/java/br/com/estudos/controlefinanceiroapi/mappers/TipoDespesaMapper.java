package br.com.estudos.controlefinanceiroapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.estudos.controlefinanceiroapi.mappers.generic.GenericMapper;
import br.com.estudos.controlefinanceiroapi.model.dtos.TipoDespesaDTO;
import br.com.estudos.controlefinanceiroapi.model.entity.TipoDespesa;

@Mapper
public interface TipoDespesaMapper extends GenericMapper<TipoDespesa, TipoDespesaDTO>{

	TipoDespesaMapper INSTANCE = Mappers.getMapper(TipoDespesaMapper.class);
	
}
