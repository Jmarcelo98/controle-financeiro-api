package br.com.estudos.controlefinanceiroapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.estudos.controlefinanceiroapi.mappers.generic.GenericMapper;
import br.com.estudos.controlefinanceiroapi.model.dtos.DespesaDTO;
import br.com.estudos.controlefinanceiroapi.model.entity.Despesa;

@Mapper
public interface DespesaMapper extends GenericMapper<Despesa, DespesaDTO> {

	DespesaMapper INSTANCE = Mappers.getMapper(DespesaMapper.class);

}
