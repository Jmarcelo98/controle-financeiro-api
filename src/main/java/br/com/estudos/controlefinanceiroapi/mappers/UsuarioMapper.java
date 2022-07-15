package br.com.estudos.controlefinanceiroapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.estudos.controlefinanceiroapi.mappers.generic.GenericMapper;
import br.com.estudos.controlefinanceiroapi.model.dtos.UsuarioDTO;
import br.com.estudos.controlefinanceiroapi.model.entity.Usuario;

@Mapper
public interface UsuarioMapper extends GenericMapper<Usuario, UsuarioDTO> {

	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

}
