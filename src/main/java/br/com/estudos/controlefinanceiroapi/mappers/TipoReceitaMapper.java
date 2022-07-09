package br.com.estudos.controlefinanceiroapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.estudos.controlefinanceiroapi.mappers.generic.GenericMapper;
import br.com.estudos.controlefinanceiroapi.model.dtos.TipoReceitaDTO;
import br.com.estudos.controlefinanceiroapi.model.entity.TipoReceita;

@Mapper
public interface TipoReceitaMapper extends GenericMapper<TipoReceita, TipoReceitaDTO>{

	TipoReceitaMapper INSTANCE = Mappers.getMapper(TipoReceitaMapper.class);
	
}
