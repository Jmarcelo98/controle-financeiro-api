package br.com.estudos.controlefinanceiroapi.mappers.generic;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.estudos.controlefinanceiroapi.model.dtos.ReceitaDTO;
import br.com.estudos.controlefinanceiroapi.model.entity.Receita;

@Mapper
public interface ReceitaMapper extends GenericMapper<Receita, ReceitaDTO> {
	
	ReceitaMapper INSTANCE = Mappers.getMapper(ReceitaMapper.class);
	
	

}
